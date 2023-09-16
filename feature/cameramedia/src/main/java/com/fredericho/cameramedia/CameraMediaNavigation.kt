package com.fredericho.cameramedia

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fredericho.core.DestinationRoute

fun NavGraphBuilder.cameraMediaNavGraph(navController: NavController) {
    composable(DestinationRoute.CAMERA_ROUTE) {
        CameraMediaScreen(navController = navController)
    }
}