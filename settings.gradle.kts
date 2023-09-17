pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "tiktokclone"
include(":app")
include(":common:composable")
include(":common:theme")
include(":domain")
include(":core")
include(":data")
include(":feature:home")
include(":feature:commentlisting")
include(":feature:creatorprofile")
include(":feature:inbox")
include(":feature:authentication")
include(":feature:loginwithemailphone")
include(":feature:friends")
include(":feature:myprofile")
include(":feature:setting")
include(":feature:cameramedia")
