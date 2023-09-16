package com.fredericho.home.tab.following

import com.fredericho.data.model.ContentCreatorFollowingModel
import com.fredericho.data.model.VideoModel

data class ViewState(
    val contentCreators : List<ContentCreatorFollowingModel>? = null,
    val isLoading : Boolean? = null,
    val error : String? = null,
)

sealed class FollowingEvent {}