package com.fredericho.data.repository.home

import com.fredericho.data.model.VideoModel
import com.fredericho.data.source.VideoDataSource.fetchVideos
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ForYouRepository @Inject constructor() {
    fun getForYouPageFeeds() : Flow<List<VideoModel>> =
        fetchVideos()
}