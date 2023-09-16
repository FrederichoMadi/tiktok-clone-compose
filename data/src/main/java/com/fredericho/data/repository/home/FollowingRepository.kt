package com.fredericho.data.repository.home

import com.fredericho.data.model.ContentCreatorFollowingModel
import com.fredericho.data.source.ContentCreatorForFollowingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FollowingRepository @Inject constructor() {
    fun getContentCreatorForFollowing() : Flow<List<ContentCreatorFollowingModel>> =
        ContentCreatorForFollowingDataSource.fetchContentCreatorForFollowing()
}