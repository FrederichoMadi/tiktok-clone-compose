package com.fredericho.inbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.fredericho.theme.R
import com.fredericho.theme.SubTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InboxScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(
                navIcon = null,
                title = stringResource(id = R.string.inbox)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            UnAuthorizedInboxScreen {
                navController.navigate(DestinationRoute.AUTHENTICATION_ROUTE)
            }
        }
    }
}

@Composable
fun UnAuthorizedInboxScreen(onClickSignup : () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_msg),
            contentDescription = null,
            modifier = Modifier.size(68.dp)
        )
        Text(
            text = stringResource(id = R.string.message_and_notifications_will_appear_here),
            color = SubTextColor,
        )
        CustomButton(
            buttonText = stringResource(id = R.string.sign_up),
            modifier = Modifier.fillMaxWidth(0.66f)
        ) {
            onClickSignup()
        }
    }
}