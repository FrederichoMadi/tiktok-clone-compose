package com.fredericho.data.repository.creatorprofile

import com.fredericho.data.model.UserModel
import com.fredericho.data.model.VideoModel
import com.fredericho.data.source.UsersDataSource.fetchSpecificUser
import com.fredericho.data.source.VideoDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreatorProfileRepository @Inject constructor() {
    fun getCreatorDetails(id : Long) : Flow<UserModel?> =
        fetchSpecificUser(id)

    fun getCreatorPublicVideo(id: Long) : Flow<List<VideoModel>> =
        VideoDataSource.fetchVideosOfParticularUser(id)
}