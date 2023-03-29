pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.3.1")
            }
            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.7.20")
            }
            if (requested.id.id.startsWith("d