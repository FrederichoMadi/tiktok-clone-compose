package com.fredericho.inbox

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fredericho.core.DestinationRoute

fun NavGraphBuilder.inboxNavGraph(navController: NavController) {
    composable(route = DestinationRoute.INBOX_ROUTE) {
        InboxScreen(navController = navController)
    }
}