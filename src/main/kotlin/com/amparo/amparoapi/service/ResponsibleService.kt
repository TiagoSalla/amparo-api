package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.create.ResponsibleCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ResponsibleUpdateRequest
import com.amparo.amparoapi.domain.model.response.ResponsibleResponse

interface ResponsibleService {
    fun findAll(): List<ResponsibleResponse>
    fun findById(id: Long): ResponsibleResponse
    fun create(responsibleRequest: ResponsibleCreateRequest)
    fun update(id: Long, responsibleRequest: ResponsibleUpdateRequest)
    fun delete(id: Long)
}