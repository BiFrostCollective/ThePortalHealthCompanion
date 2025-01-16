pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google() // Google's Maven repository
        mavenCentral() // Central Maven repository
        maven { url = uri("https://jitpack.io") } // JitPack repository
    }
}
rootProject.name = "ThePortalExperience"
include(":app")