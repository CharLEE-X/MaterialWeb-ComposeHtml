plugins {
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    id("org.jetbrains.dokka") version libs.versions.dokka apply false
}
