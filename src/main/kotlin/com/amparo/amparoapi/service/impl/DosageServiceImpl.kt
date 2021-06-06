package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.DosageRequest
import com.amparo.amparoapi.domain.model.response.DosageResponse
import com.amparo.amparoapi.domain.repository.DosageRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.DosageService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class DosageServiceImpl(private val dosageRepository: DosageRepository) : DosageService {
    override fun findAll(): List<DosageResponse> = dosageRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): DosageResponse {
        val dosage = dosageRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        return dosage.toResponse()
    }

    override fun create(dosageRequest: DosageRequest) {
        dosageRepository.save(dosageRequest.toEntity())
    }

    override fun update(id: Long, dosageRequest: DosageRequest) {
        val dosage = dosageRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val updatedDosage = dosageRequest.toEntity(dosage.createdAt)
        updatedDosage.id = id
        dosageRepository.save(updatedDosage)
    }

    override fun delete(id: Long) {
        dosageRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        dosageRepository.deleteById(id)
    }
}