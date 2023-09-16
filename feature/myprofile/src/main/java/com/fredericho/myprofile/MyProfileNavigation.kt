package com.fredericho.myprofile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fredericho.core.DestinationRoute

fun NavGraphBuilder.myProfileNavGraph(navController: NavController) {
    composable(route = DestinationRoute.MY_PROFILE_ROUTE) {
        MyProfileScreen(navController = navController)
    }
}