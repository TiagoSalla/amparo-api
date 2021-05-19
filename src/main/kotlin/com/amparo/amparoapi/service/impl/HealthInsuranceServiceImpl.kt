package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.create.HealthInsuranceCreateRequest
import com.amparo.amparoapi.domain.model.request.update.HealthInsuranceUpdateRequest
import com.amparo.amparoapi.domain.model.response.HealthInsuranceResponse
import com.amparo.amparoapi.domain.repository.HealthInsuranceRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.HealthInsuranceService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class HealthInsuranceServiceImpl(private val healthInsuranceRepository: HealthInsuranceRepository) : HealthInsuranceService {
    override fun findAll(): List<HealthInsuranceResponse> =
        healthInsuranceRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): HealthInsuranceResponse {
        val healthInsurance = healthInsuranceRepository.findById(id)
        if(healthInsurance.isPresent) {
            return healthInsurance.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(healthInsuranceRequest: HealthInsuranceCreateRequest) {
        healthInsuranceRepository.save(healthInsuranceRequest.toEntity())
    }

    override fun update(id: Long, healthInsuranceRequest: HealthInsuranceUpdateRequest) {
        if(healthInsuranceRepository.findById(id).isPresent) {
            val healthInsurance = healthInsuranceRequest.toEntity()
            healthInsurance.id = id
            healthInsuranceRepository.save(healthInsurance)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if(healthInsuranceRepository.findById(id).isPresent) {
            healthInsuranceRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}