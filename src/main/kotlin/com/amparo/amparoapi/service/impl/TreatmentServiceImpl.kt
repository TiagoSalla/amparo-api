package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.TreatmentRequest
import com.amparo.amparoapi.domain.model.response.TreatmentResponse
import com.amparo.amparoapi.domain.repository.MedicineRepository
import com.amparo.amparoapi.domain.repository.ProfessionalRepository
import com.amparo.amparoapi.domain.repository.ResidentRepository
import com.amparo.amparoapi.domain.repository.TreatmentRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.TreatmentService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class TreatmentServiceImpl(private val treatmentRepository: TreatmentRepository,
                                 private val residentRepository: ResidentRepository,
                                 private val medicineRepository: MedicineRepository,
                                 private val professionalRepository: ProfessionalRepository) : TreatmentService {
    override fun findAll(): List<TreatmentResponse> = treatmentRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): TreatmentResponse {
        val treatment = treatmentRepository.findById(id)
        if (treatment.isPresent) {
            return treatment.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(treatmentRequest: TreatmentRequest) {
        val medicineEntityList = treatmentRequest.medicineIdList.mapNotNull {
            medicineRepository.findById(it)
                .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) } }
        val residentEntity = residentRepository.findById(treatmentRequest.residentId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val professionalEntity = professionalRepository.findById(treatmentRequest.responsibleProfessionalId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        treatmentRepository.save(treatmentRequest.toEntity(residentEntity, professionalEntity, medicineEntityList))
    }

    override fun update(id: Long, treatmentRequest: TreatmentRequest) {
        if (treatmentRepository.findById(id).isPresent) {
            val medicineEntityList = treatmentRequest.medicineIdList.mapNotNull {
                medicineRepository.findById(it)
                    .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) } }
            val residentEntity = residentRepository.findById(treatmentRequest.residentId)
                .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
            val professionalEntity = professionalRepository.findById(treatmentRequest.responsibleProfessionalId)
                .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
            val treatment = treatmentRequest.toEntity(residentEntity, professionalEntity, medicineEntityList)
            treatment.id = id
            treatmentRepository.save(treatment)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if (treatmentRepository.findById(id).isPresent) {
            treatmentRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}