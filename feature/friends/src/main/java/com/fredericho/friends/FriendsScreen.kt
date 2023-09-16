package com.fredericho.friends

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.fredericho.composable.TopBar
import com.fredericho.core.DestinationRoute.AUTHENTICATION_ROUTE
import com.fredericho.theme.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(
                navIcon = null,
                title = stringResource(id = R.string.friends)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

        }
    }

    LaunchedEffect(key1 = Unit) {
        navController.apply {
            popBackStack()
            navController.navigate(AUTHENTICATION_ROUTE)
        }
    }
}