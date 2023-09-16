package com.fredericho.commentlisting

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fredericho.core.DestinationRoute
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet

@OptIn(ExperimentalMaterialNavigationApi::class)
fun NavGraphBuilder.commentListNavigation(navController: NavController) {
    bottomSheet(DestinationRoute.COMMENT_BOTTOM_SHEET_ROUTE) {
        CommentLIstScreen {
            navController.navigateUp()
        }
    }
}