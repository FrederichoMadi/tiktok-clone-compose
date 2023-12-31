package com.fredericho.myprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fredericho.composable.CustomButton
import com.fredericho.composable.TopBar
import com.fredericho.core.DestinationRoute
import com.fredericho.core.DestinationRoute.SETTING_ROUTE
import com.fredericho.theme.R
import com.fredericho.theme.SubTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(
                navIcon = null,
                title = stringResource(id = R.string.profile),
                actions = {
                    IconButton(onClick = {
                        navController.navigate(SETTING_ROUTE)
                    }) {
                        Icon(painter = painterResource(id = R.drawable.ic_hamburger), contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            UnAuthorizedInboxScreen {
                navController.navigate(DestinationRoute.AUTHENTICATION_ROUTE)
            }
        }
    }
}

@Composable
fun UnAuthorizedInboxScreen(onClickSignUp : () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = null,
            modifier = Modifier.size(68.dp)
            )
        Text(
            text = stringResource(id = R.string.sign_up_for_an_account),
            color = SubTextColor,
        )
        CustomButton(
            buttonText = stringResource(id = R.string.sign_up),
            modifier = Modifier.fillMaxWidth(0.66f)
        ) {
            onClickSignUp()
        }
    }
}