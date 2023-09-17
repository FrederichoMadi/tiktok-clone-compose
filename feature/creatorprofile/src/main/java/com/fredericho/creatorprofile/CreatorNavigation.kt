package com.fredericho.creatorprofile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fredericho.core.DestinationRoute.COMMENT_BOTTOM_SHEET_ROUTE
import com.fredericho.core.DestinationRoute.CREATOR_PROFILE_ROUTE
import com.fredericho.core.DestinationRoute.FORMATTED_COMPLETE_CREATOR_VIDEO_ROUTE
import com.fredericho.core.DestinationRoute.PassedKey.USER_ID
import com.fredericho.core.DestinationRoute.PassedKey.VIDEO_INDEX
import com.fredericho.creatorprofile.screen.creatorprofile.CreatorProfileScreen
import com.fredericho.creatorprofile.screen.creatorvideo.CreatorVideoPagerScreen

fun NavGraphBuilder.creatorProfileNavGraph(navController: NavController) {
    composable(route = "$CREATOR_PROFILE_ROUTE/{$USER_ID}",
        arguments = listOf(
            navArgument(USER_ID) { type = NavType.LongType }
        )
    ) {
        CreatorProfileScreen(
            onClickNavIcon = { navController.navigateUp() },
            navController = navController
        )
    }

    composable(route = FORMATTED_COMPLETE_CREATOR_VIDEO_ROUTE,
        arguments = listOf(
            navArgument(USER_ID) { type = NavType.LongType },
            navArgument(VIDEO_INDEX) { type = NavType.IntType }
        )
    ) {
        CreatorVideoPagerScreen(
            onClickNavIcon = { navController.navigateUp() },
            onClickComment = { navController.navigate(COMMENT_BOTTOM_SHEET_ROUTE) },
            onClickAudio = {},
            onClickUser = { navController.navigateUp() },
        )
    }
}