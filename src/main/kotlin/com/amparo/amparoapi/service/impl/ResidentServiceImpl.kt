package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.ResidentRequest
import com.amparo.amparoapi.domain.model.response.ResidentResponse
import com.amparo.amparoapi.domain.repository.HealthInsuranceRepository
import com.amparo.amparoapi.domain.repository.ResidentRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.ResidentService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class ResidentServiceImpl(
    private val residentRepository: ResidentRepository,
    private val healthInsuranceRepository: HealthInsuranceRepository,
) : ResidentService {
    override fun findAll(): List<ResidentResponse> = residentRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): ResidentResponse {
        val resident = residentRepository.findById(id)
        if (resident.isPresent) {
            return resident.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(residentRequest: ResidentRequest) {
        val healthInsurance = healthInsuranceRepository.findById(residentRequest.healthInsuranceId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        residentRepository.save(residentRequest.toEntity(healthInsurance))
    }

    override fun update(id: Long, residentRequest: ResidentRequest) {
        if (residentRepository.findById(id).isPresent) {
            val healthInsurance = healthInsuranceRepository.findById(residentRequest.healthInsuranceId)
                .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
            val resident = residentRequest.toEntity(healthInsurance)
            resident.id = id
            residentRepository.save(resident)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if (residentRepository.findById(id).isPresent) {
            residentRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}