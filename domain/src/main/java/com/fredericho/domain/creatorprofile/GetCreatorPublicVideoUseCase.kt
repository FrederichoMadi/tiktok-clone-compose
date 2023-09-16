package com.fredericho.domain.creatorprofile

import com.fredericho.data.model.VideoModel
import com.fredericho.data.repository.creatorprofile.CreatorProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCreatorPublicVideoUseCase @Inject constructor(
    private val creatorProfileRepository: CreatorProfileRepository
) {
    operator fun invoke(id : Long) : Flow<List<VideoModel>> {
        return creatorProfileRepository.getCreatorPublicVideo(id)
    }
}