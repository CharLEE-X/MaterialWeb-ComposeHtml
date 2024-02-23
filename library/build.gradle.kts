plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    id("convention.publication")
}

group = "${AppConfig.groupId}.${AppConfig.artifactId}"
version = AppConfig.version

kotlin {
    applyDefaultHierarchyTemplate()

    js(IR) {
        browser {
            commonWebpackConfig {
                scssSupport {
                    enabled.set(true)
                }
            }
        }
    }

    sourceSets {
        jsMain.dependencies {
            implementation(compose.html.core)
            implementation(compose.runtime)
            implementation(libs.kobweb.silk)
            api(npm("@material/web", libs.versions.materialWeb.get()))
        }
    }
}
