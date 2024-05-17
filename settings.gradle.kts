pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven (url="https://jitpack.io")
        maven (url="https://jcenter.bintray.com")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven (url="https://jitpack.io")
        gradlePluginPortal()
        maven (url="https://jcenter.bintray.com")
    }
}

rootProject.name = "Food Deliver"
include(":app")
 