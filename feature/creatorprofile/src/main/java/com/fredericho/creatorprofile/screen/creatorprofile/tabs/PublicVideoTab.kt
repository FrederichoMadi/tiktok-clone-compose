package com.fredericho.creatorprofile.screen.creatorprofile.tabs

import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.fredericho.creatorprofile.component.VideoGrid
import com.fredericho.creatorprofile.screen.creatorprofile.CreatorProfileViewModel
import com.fredericho.data.model.VideoModel

@Composable
fun PublicVideoTab(
    viewModel: CreatorProfileViewModel,
    scrollState: ScrollState,
    onClickVideo : (VideoModel, Int) -> Unit,
) {
    val creatorPublicVideos by viewModel.publicVideosList.collectAsState()
    VideoGrid(
        scrollState = scrollState,
        videoList = creatorPublicVideos,
        onClickVideo = onClickVideo
    )
}