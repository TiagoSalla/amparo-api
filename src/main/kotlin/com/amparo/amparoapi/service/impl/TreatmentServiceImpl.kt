package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.create.TreatmentCreateRequest
import com.amparo.amparoapi.domain.model.request.update.TreatmentUpdateRequest
import com.amparo.amparoapi.domain.model.response.TreatmentResponse
import com.amparo.amparoapi.domain.repository.TreatmentRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.TreatmentService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class TreatmentServiceImpl(private val treatmentRepository: TreatmentRepository) : TreatmentService {
    override fun findAll(): List<TreatmentResponse> = treatmentRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): TreatmentResponse {
        val treatment = treatmentRepository.findById(id)
        if(treatment.isPresent) {
            return treatment.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(treatmentRequest: TreatmentCreateRequest) {
        treatmentRepository.save(treatmentRequest.toEntity())
    }

    override fun update(id: Long, treatmentRequest: TreatmentUpdateRequest) {
        if(treatmentRepository.findById(id).isPresent) {
            val treatment = treatmentRequest.toEntity()
            treatment.id = id
            treatmentRepository.save(treatment)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if(treatmentRepository.findById(id).isPresent) {
            treatmentRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}