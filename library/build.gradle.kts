plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    id("module.publication")
}

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
//        binaries.executable()
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
