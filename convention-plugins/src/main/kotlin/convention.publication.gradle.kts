/*
 * Copyright (c) 2024 Adrian Witaszak - CharLEE-X. Use of this source code is governed by the Apache 2.0 license.
 */

import java.util.Properties

plugins {
    `maven-publish`
    signing
    id("org.jetbrains.dokka")
}

ext["signing.key"] = null
ext["signing.password"] = null
ext["ossrh.username"] = null
ext["ossrh.password"] = null

val secretPropsFile = project.rootProject.file("local.properties")
if (secretPropsFile.exists()) {
    secretPropsFile.reader().use {
        Properties().apply {
            load(it)
        }
    }.onEach { (name, value) ->
        ext[name.toString()] = value
    }
} else {
    ext["signing.key"] = System.getenv("SIGNING_KEY")
    ext["signing.password"] = System.getenv("SIGNING_PASSWORD")
    ext["ossrh.username"] = System.getenv("OSSRH_USERNAME")
    ext["ossrh.password"] = System.getenv("OSSRH_PASSWORD")
}

val dokkaOutputDir = "$buildDir/dokka"

tasks.dokkaHtml {
    outputDirectory.set(file(dokkaOutputDir))
}

val deleteDokkaOutputDir by tasks.register<Delete>("deleteDokkaOutputDirectory") {
    delete(dokkaOutputDir)
}

val javadocJar = tasks.register<Jar>("javadocJar") {
    dependsOn(deleteDokkaOutputDir, tasks.dokkaHtml)
    archiveClassifier.set("javadoc")
    from(dokkaOutputDir)
}

tasks.withType<AbstractPublishToMaven>().configureEach {
    val signingTasks = tasks.withType<Sign>()
    dependsOn(signingTasks)
}

afterEvaluate {
    publishing {
        repositories {
            maven {
                name = "sonatype"
                setUrl("https://s01.oss.sonatype.org/service/local/")
                credentials {
                    username = getExtraString("ossrhUsername")
                    password = getExtraString("ossrhPassword")
                }
            }
        }
        publications.withType<MavenPublication> {
            // Stub javadoc.jar artifact
            artifact(tasks.register("${name}JavadocJar", Jar::class) {
                archiveClassifier.set("javadoc")
                archiveAppendix.set(this@withType.name)
            })

            // Provide artifacts information required by Maven Central
            pom {
                name.set(AppConfig.projectName)
                description.set(AppConfig.description)
                url.set(AppConfig.url)

                licenses {
                    license {
                        name.set(AppConfig.Licence.name)
                        url.set(AppConfig.Licence.url)
                    }
                }
                developers {
                    developer {
                        id.set(AppConfig.Developer.id)
                        name.set(AppConfig.Developer.name)
                        email.set(AppConfig.Developer.email)
                        organization.set(AppConfig.Developer.organization)
                        organizationUrl.set(AppConfig.Developer.organizationUrl)
                    }
                }
                scm {
                    url.set(AppConfig.url)
                }
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(
        getExtraString("signing.key"),
        getExtraString("signing.password")
    )
    sign(publishing.publications)
}

fun getExtraString(name: String): String = ext[name]?.toString()
    ?: findProperty(name)?.toString()
    ?: System.getenv(name)?.toString()
    ?: ""
