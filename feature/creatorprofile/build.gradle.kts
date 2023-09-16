plugins {
    id("plugin.android-common")
}

android {
    namespace = "com.fredericho.creatorprofile"
}

dependencies {
    COMMON_THEME
    COMMON_COMPOSABLE
    DOMAIN
    DATA
    CORE
}