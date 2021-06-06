package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.HealthInsuranceRequest
import com.amparo.amparoapi.domain.model.response.HealthInsuranceResponse
import com.amparo.amparoapi.domain.model.response.HealthInsuranceTypeResponse

interface HealthInsuranceService {
    fun findAll(): List<HealthInsuranceResponse>
    fun findById(id: Long): HealthInsuranceResponse
    fun findAllTypes(): List<HealthInsuranceTypeResponse>
    fun create(healthInsuranceRequest: HealthInsuranceRequest)
    fun update(id: Long, healthInsuranceRequest: HealthInsuranceRequest)
    fun delete(id: Long)
}