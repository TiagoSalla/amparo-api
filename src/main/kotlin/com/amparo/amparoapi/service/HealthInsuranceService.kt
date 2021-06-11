package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.HealthInsuranceRequest
import com.amparo.amparoapi.domain.model.response.HealthInsuranceResponse

interface HealthInsuranceService {
    fun findAll(): List<HealthInsuranceResponse>
    fun findById(id: Long): HealthInsuranceResponse
    fun create(healthInsuranceRequest: HealthInsuranceRequest)
    fun update(id: Long, healthInsuranceRequest: HealthInsuranceRequest)
    fun delete(id: Long)
}