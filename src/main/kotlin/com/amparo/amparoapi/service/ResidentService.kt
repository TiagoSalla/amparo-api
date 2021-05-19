package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.create.ResidentCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ResidentUpdateRequest
import com.amparo.amparoapi.domain.model.response.ResidentResponse

interface ResidentService {
    fun findAll(): List<ResidentResponse>
    fun findById(id: Long): ResidentResponse
    fun create(residentRequest: ResidentCreateRequest)
    fun update(id: Long, residentRequest: ResidentUpdateRequest)
    fun delete(id: Long)
}