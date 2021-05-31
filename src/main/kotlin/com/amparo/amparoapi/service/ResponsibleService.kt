package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.ResponsibleRequest
import com.amparo.amparoapi.domain.model.response.ResponsibleResponse

interface ResponsibleService {
    fun findAll(): List<ResponsibleResponse>
    fun findById(id: Long): ResponsibleResponse
    fun create(responsibleRequest: ResponsibleRequest)
    fun update(id: Long, responsibleRequest: ResponsibleRequest)
    fun delete(id: Long)
}