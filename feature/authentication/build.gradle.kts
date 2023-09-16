plugins {
    id("plugin.android-common")
}

android {
    namespace = "com.fredericho.authentication"
}


dependencies {
    COMMON_THEME
    DOMAIN
    DATA
    CORE
    COMMON_COMPOSABLE
}