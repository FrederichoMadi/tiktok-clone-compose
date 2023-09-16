plugins {
    id("plugin.android-common")
}

android {
    namespace = "com.fredericho.cameramedia"
}


dependencies {
    COMMON_THEME
    COMMON_COMPOSABLE
    DOMAIN
    DATA
    CORE
    cameraXDependencies()
}