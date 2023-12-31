package com.fredericho.creatorprofile.screen.creatorprofile.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fredericho.core.extension.Space
import com.fredericho.theme.R
import com.fredericho.creatorprofile.screen.creatorprofile.CreatorProfileViewModel

@Composable
fun LikeVideoTab(
    viewModel: CreatorProfileViewModel,
) {
    val state by viewModel.viewState.collectAsState()

    state?.creatorProfile?.apply {
        if(isLikedVideoPrivate) {
            PrivateLikedVideoLayout(username = this.uniqueUserName)
        } else {
            //list liked video
        }
    }
}

@Composable
internal fun PrivateLikedVideoLayout(username : String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        30.dp.Space()
        Text(
            text = stringResource(id = R.string.this_users_liked_videos),
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = " ${stringResource(id = R.string.videos_liked_by)} $username ${
                stringResource(id = R.string.currently_hidden)
            }",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth(0.9f)
        )
    }
}