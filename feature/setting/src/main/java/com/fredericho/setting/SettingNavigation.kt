package com.fredericho.setting

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fredericho.core.DestinationRoute

fun NavGraphBuilder.settingNavGraph(navController: NavController) {
    composable(route = DestinationRoute.SETTING_ROUTE) {
        SettingScreen(navController = navController)
    }
}