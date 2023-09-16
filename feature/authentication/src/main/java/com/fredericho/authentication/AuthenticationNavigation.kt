package com.fredericho.authentication

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.fredericho.core.DestinationRoute.AUTHENTICATION_ROUTE
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet

@OptIn(ExperimentalMaterialNavigationApi::class)
fun NavGraphBuilder.authenticationNavGraph(navController: NavController) {
    bottomSheet(route = AUTHENTICATION_ROUTE) {
        AuthenticationScreen(navController = navController)
    }
}