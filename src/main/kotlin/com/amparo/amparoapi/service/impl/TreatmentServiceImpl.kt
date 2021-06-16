package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.MedicineEntity
import com.amparo.amparoapi.domain.model.request.TreatmentRequest
import com.amparo.amparoapi.domain.model.response.TreatmentOptions
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
        val treatment = treatmentRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }

        return treatment.toResponse()
    }

    override fun getSelectionOptions(): TreatmentOptions {
        val residentList = residentRepository.findAll()
        val professionalList = professionalRepository.findAll()
        val medicineList = medicineRepository.findAll()

        return TreatmentOptions(residentList.map { it.toResponse() },
            professionalList.map { it.toResponse() },
            medicineList.map { it.toResponse() })
    }

    override fun create(treatmentRequest: TreatmentRequest) {
        val medicineEntityList = findMedicineEntityListById(treatmentRequest.medicineIdList)
        val residentEntity = residentRepository.findById(treatmentRequest.residentId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val professionalEntity = professionalRepository.findById(treatmentRequest.responsibleProfessionalId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }

        treatmentRepository.save(treatmentRequest.toEntity(residentEntity, professionalEntity, medicineEntityList))
    }

    override fun update(id: Long, treatmentRequest: TreatmentRequest) {
        val treatment = treatmentRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val medicineEntityList = findMedicineEntityListById(treatmentRequest.medicineIdList)
        val residentEntity = residentRepository.findById(treatmentRequest.residentId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val professionalEntity = professionalRepository.findById(treatmentRequest.responsibleProfessionalId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }

        val updatedTreatment =
            treatmentRequest.toEntity(residentEntity, professionalEntity, medicineEntityList, treatment.createdAt)
        updatedTreatment.id = id
        treatmentRepository.save(updatedTreatment)
    }

    override fun delete(id: Long) {
        treatmentRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }

        treatmentRepository.deleteById(id)
    }

    private fun findMedicineEntityListById(medicineIdList: List<Long>): List<MedicineEntity> {
        return medicineIdList.mapNotNull {
            medicineRepository.findById(it).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) } }
    }
}