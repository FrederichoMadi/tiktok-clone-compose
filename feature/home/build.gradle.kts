plugins {
    id("plugin.android-common")
}

android {
    namespace = "com.fredericho.home"
}

dependencies {
    COMMON_THEME
    COMMON_COMPOSABLE
    DOMAIN
    DATA
    CORE
    media3Dependency()
}