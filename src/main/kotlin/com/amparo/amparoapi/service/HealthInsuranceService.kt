package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.create.HealthInsuranceCreateRequest
import com.amparo.amparoapi.domain.model.request.update.HealthInsuranceUpdateRequest
import com.amparo.amparoapi.domain.model.response.HealthInsuranceResponse

interface HealthInsuranceService {
    fun findAll(): List<HealthInsuranceResponse>
    fun findById(id: Long): HealthInsuranceResponse
    fun create(healthInsuranceRequest: HealthInsuranceCreateRequest)
    fun update(id: Long, healthInsuranceRequest: HealthInsuranceUpdateRequest)
    fun delete(id: Long)
}