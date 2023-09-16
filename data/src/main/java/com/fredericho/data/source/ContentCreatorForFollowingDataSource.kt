package com.fredericho.data.source

import com.fredericho.data.model.ContentCreatorFollowingModel
import com.fredericho.data.source.UsersDataSource.charliePuth
import com.fredericho.data.source.UsersDataSource.duaLipa
import com.fredericho.data.source.UsersDataSource.imagineDragons
import com.fredericho.data.source.UsersDataSource.kylieJenner
import com.fredericho.data.source.UsersDataSource.shana
import com.fredericho.data.source.VideoDataSource.CharliePuthVideos.charlieputh_vid1
import com.fredericho.data.source.VideoDataSource.DanielVideos.danielVideosList
import com.fredericho.data.source.VideoDataSource.DuaLipaVideos.dua_vid1
import com.fredericho.data.source.VideoDataSource.GoogleVideos.google_vid1
import com.fredericho.data.source.VideoDataSource.ImagineDragonsVideos.imaginedragons_vid1
import com.fredericho.data.source.VideoDataSource.KylieJennerVideos.kylie_vid1
import com.fredericho.data.source.VideoDataSource.ShanaVideos.shana_vid1
import com.fredericho.data.source.VideoDataSource.TaylorVideos.taylor_vid2
import com.fredericho.data.source.VideoDataSource.ZoyaVideos.zoyaVideosList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object ContentCreatorForFollowingDataSource {

    fun fetchContentCreatorForFollowing() : Flow<List<ContentCreatorFollowingModel>> {
        return flow {
            val creatorForFollowing : List<ContentCreatorFollowingModel> = listOf(
                ContentCreatorFollowingModel(
                    userModel = kylieJenner,
                    coverVideo = kylie_vid1
                ),
                ContentCreatorFollowingModel(
                    userModel = charliePuth,
                    coverVideo = charlieputh_vid1
                ),
                ContentCreatorFollowingModel(
                    userModel = duaLipa,
                    coverVideo = dua_vid1
                ),
                ContentCreatorFollowingModel(
                    userModel = imagineDragons,
                    coverVideo = imaginedragons_vid1
                ),
                ContentCreatorFollowingModel(
                    userModel = UsersDataSource.taylor,
                    coverVideo = taylor_vid2
                ),
                ContentCreatorFollowingModel(
                    userModel = UsersDataSource.zoya,
                    coverVideo = zoyaVideosList.random()
                ),
                ContentCreatorFollowingModel(
                    userModel = UsersDataSource.google,
                    coverVideo = google_vid1
                ),

                ContentCreatorFollowingModel(
                    userModel = UsersDataSource.daniel,
                    coverVideo = danielVideosList.random()
                ),

                ContentCreatorFollowingModel(
                    userModel = shana,
                    coverVideo = shana_vid1
                ),
            )
            emit(creatorForFollowing.shuffled())
        }
    }

}