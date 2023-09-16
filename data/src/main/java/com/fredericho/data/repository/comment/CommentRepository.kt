package com.fredericho.data.repository.comment

import com.fredericho.data.model.CommentList
import com.fredericho.data.source.CommentDataSource.fetchComment
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CommentRepository @Inject constructor() {
    fun getComment(videoId : String) : Flow<CommentList> =
        fetchComment(videoId)
}