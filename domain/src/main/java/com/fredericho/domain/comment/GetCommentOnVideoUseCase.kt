package com.fredericho.domain.comment

import com.fredericho.data.model.CommentList
import com.fredericho.data.repository.comment.CommentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCommentOnVideoUseCase @Inject constructor(private val commentRepository: CommentRepository) {
    operator fun invoke(videoId : String) : Flow<CommentList> {
        return commentRepository.getComment(videoId)
    }
}