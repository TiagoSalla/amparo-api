package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.create.DosageCreateRequest
import com.amparo.amparoapi.domain.model.request.update.DosageUpdateRequest
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
        val dosage = dosageRepository.findById(id)
        if(dosage.isPresent) {
            return dosage.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(dosageRequest: DosageCreateRequest) {
        dosageRepository.save(dosageRequest.toEntity())
    }

    override fun update(id: Long, dosageRequest: DosageUpdateRequest) {
        if(dosageRepository.findById(id).isPresent) {
            val dosage = dosageRequest.toEntity()
            dosage.id = id
            dosageRepository.save(dosage)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if(dosageRepository.findById(id).isPresent) {
            dosageRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}