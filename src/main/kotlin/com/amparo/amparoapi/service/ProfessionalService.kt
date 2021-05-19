package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.create.ProfessionalCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ProfessionalUpdateRequest
import com.amparo.amparoapi.domain.model.response.ProfessionalResponse

interface ProfessionalService {
    fun findAll(): List<ProfessionalResponse>
    fun findById(id: Long): ProfessionalResponse
    fun create(professionalRequest: ProfessionalCreateRequest)
    fun update(id: Long, professionalRequest: ProfessionalUpdateRequest)
    fun delete(id: Long)
}