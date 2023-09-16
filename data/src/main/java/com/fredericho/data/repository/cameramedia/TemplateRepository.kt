package com.fredericho.data.repository.cameramedia

import com.fredericho.data.model.TemplateModel
import com.fredericho.data.source.TemplateDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TemplateRepository @Inject constructor() {
    fun getTemplates() : Flow<List<TemplateModel>> =
        TemplateDataSource.fetchTemplates()
}