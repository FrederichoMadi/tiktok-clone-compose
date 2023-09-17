package com.fredericho.tiktokclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.fredericho.authentication.authenticationNavGraph
import com.fredericho.cameramedia.cameraMediaNavGraph
import com.fredericho.commentlisting.commentListNavigation
import com.fredericho.core.DestinationRoute.HOME_SCREEN_ROUTE
import com.fredericho.creatorprofile.creatorProfileNavGraph
import com.fredericho.friends.friendsNavGraph
import com.fredericho.home.homeNavGraph
import com.fredericho.inbox.inboxNavGraph
import com.fredericho.loginwithemailphone.loginEmailPhoneNavGraph
import com.fredericho.myprofile.myProfileNavGraph
import com.fredericho.setting.settingNavGraph

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_SCREEN_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeNavGraph(navController)
        authenticationNavGraph(navController)
        friendsNavGraph(navController)
        myProfileNavGraph(navController)
        settingNavGraph(navController)
        inboxNavGraph(navController)
        loginEmailPhoneNavGraph(navController)
        commentListNavigation(navController)
        cameraMediaNavGraph(navController)
        creatorProfileNavGraph(navController)
    }
}