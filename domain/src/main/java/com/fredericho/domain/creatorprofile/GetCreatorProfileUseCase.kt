package com.fredericho.domain.creatorprofile

import com.fredericho.data.model.UserModel
import com.fredericho.data.repository.creatorprofile.CreatorProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCreatorProfileUseCase @Inject constructor(
    private val creatorProfileRepository: CreatorProfileRepository
) {
    operator fun invoke(id : Long) : Flow<UserModel?> {
        return creatorProfileRepository.getCreatorDetails(id)
    }
}