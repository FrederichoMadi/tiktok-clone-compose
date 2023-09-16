plugins {
    id("plugin.android-common")
}

android {
    namespace = "com.fredericho.myprofile"
}

dependencies {
    COMMON_THEME
    COMMON_COMPOSABLE
    DOMAIN
    DATA
    CORE
}