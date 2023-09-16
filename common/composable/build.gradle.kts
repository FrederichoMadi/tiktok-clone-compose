plugins {
    id("plugin.android-common")
}

android {
    namespace = "com.fredericho.composable"
}


dependencies {
    COMMON_THEME
    DOMAIN
    DATA
    CORE
    media3Dependency()
}