package com.fredericho.domain.cameramedia

import com.fredericho.data.model.TemplateModel
import com.fredericho.data.repository.cameramedia.TemplateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTemplateUseCase @Inject constructor(
    private val templateRepository: TemplateRepository
) {
    operator fun invoke() : Flow<List<TemplateModel>> {
        return templateRepository.getTemplates()
    }
}