package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.ResidentRequest
import com.amparo.amparoapi.domain.model.response.ResidentResponse

interface ResidentService {
    fun findAll(): List<ResidentResponse>
    fun findById(id: Long): ResidentResponse
    fun create(residentRequest: ResidentRequest)
    fun update(id: Long, residentRequest: ResidentRequest)
    fun delete(id: Long)
}