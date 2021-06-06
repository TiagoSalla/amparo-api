package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.HealthInsuranceEntity
import com.amparo.amparoapi.domain.model.request.HealthInsuranceRequest
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
        val resident = residentRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }

        return resident.toResponse()
    }

    override fun create(residentRequest: ResidentRequest) {
        val healthInsurance = findOrCreateHealthInsuranceEntity(residentRequest.healthInsurance)
        residentRepository.save(residentRequest.toEntity(healthInsurance))
    }

    override fun update(id: Long, residentRequest: ResidentRequest) {
        val resident = residentRepository.findById(id)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }

        val healthInsurance = findOrCreateHealthInsuranceEntity(residentRequest.healthInsurance)
        val updatedResident = residentRequest.toEntity(healthInsurance, resident.createdAt)
        updatedResident.id = id
        residentRepository.save(updatedResident)
    }

    override fun delete(id: Long) {
        residentRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }

        residentRepository.deleteById(id)
    }

    private fun findOrCreateHealthInsuranceEntity(healthInsuranceRequest: HealthInsuranceRequest): HealthInsuranceEntity {
        val healthInsuranceEntity =
            healthInsuranceRepository.findByHealthInsuranceTypeAndInscriptionAndObservation(
                healthInsuranceRequest.type,
                healthInsuranceRequest.inscription,
                healthInsuranceRequest.observation,
            )

        return if (healthInsuranceEntity.isPresent) {
            healthInsuranceEntity.get()
        } else {
            healthInsuranceRepository.save(healthInsuranceRequest.toEntity())
        }
    }
}