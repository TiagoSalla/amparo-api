package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.ProfessionalRequest
import com.amparo.amparoapi.domain.model.response.ProfessionalResponse

interface ProfessionalService {
    fun findAll(): List<ProfessionalResponse>
    fun findById(id: Long): ProfessionalResponse
    fun create(professionalRequest: ProfessionalRequest)
    fun update(id: Long, professionalRequest: ProfessionalRequest)
    fun delete(id: Long)
}