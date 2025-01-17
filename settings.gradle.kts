enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
//        jcenter()
        mavenCentral()
    }
}

rootProject.name = "DailyPulse"
include(":androidApp")
include(":shared")