package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.enums.HealthInsuranceType
import com.amparo.amparoapi.domain.model.request.HealthInsuranceRequest
import com.amparo.amparoapi.domain.model.response.HealthInsuranceResponse
import com.amparo.amparoapi.domain.repository.HealthInsuranceRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.HealthInsuranceService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class HealthInsuranceServiceImpl(
    private val healthInsuranceRepository: HealthInsuranceRepository
) : HealthInsuranceService {
    override fun findAll(): List<HealthInsuranceResponse> =
        healthInsuranceRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): HealthInsuranceResponse {
        val healthInsurance = healthInsuranceRepository.findById(id)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        return healthInsurance.toResponse()
    }

    override fun create(healthInsuranceRequest: HealthInsuranceRequest) {
        healthInsuranceRepository.save(healthInsuranceRequest.toEntity())
    }

    override fun update(id: Long, healthInsuranceRequest: HealthInsuranceRequest) {
        val healthInsurance = healthInsuranceRepository.findById(id)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val updatedHealthInsurance = healthInsuranceRequest.toEntity(healthInsurance.createdAt)
        updatedHealthInsurance.id = id
        healthInsuranceRepository.save(updatedHealthInsurance)
    }

    override fun delete(id: Long) {
        healthInsuranceRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        healthInsuranceRepository.deleteById(id)
    }
}