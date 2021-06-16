package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.DosageEntity
import com.amparo.amparoapi.domain.model.request.DosageRequest
import com.amparo.amparoapi.domain.model.request.MedicineRequest
import com.amparo.amparoapi.domain.model.response.MedicineResponse
import com.amparo.amparoapi.domain.repository.DosageRepository
import com.amparo.amparoapi.domain.repository.MedicineRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.MedicineService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class MedicineServiceImpl(
    private val medicineRepository: MedicineRepository,
    private val dosageRepository: DosageRepository
) : MedicineService {
    override fun findAll(): List<MedicineResponse> = medicineRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): MedicineResponse {
        val medicine = medicineRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        return medicine.toResponse()
    }

    override fun create(medicineRequest: MedicineRequest) {
        val dosageEntity = findOrCreateDosageEntity(medicineRequest.dosage)
        medicineRepository.save(medicineRequest.toEntity(dosageEntity))
    }

    override fun update(id: Long, medicineRequest: MedicineRequest) {
        val medicine = medicineRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val dosageEntity = findOrCreateDosageEntity(medicineRequest.dosage)
        val updatedMedicine = medicineRequest.toEntity(dosageEntity, medicine.createdAt)
        updatedMedicine.id = id
        medicineRepository.save(updatedMedicine)
    }

    override fun delete(id: Long) {
        medicineRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        medicineRepository.deleteById(id)
    }

    private fun findOrCreateDosageEntity(dosageRequest: DosageRequest): DosageEntity {
        val dosageEntity =
            dosageRepository.findByQuantityAndQuantityTypeAndFrequencyAndFrequencyTypeAndAdministrationRoute(
                dosageRequest.quantity,
                dosageRequest.quantityType,
                dosageRequest.frequency,
                dosageRequest.frequencyType,
                dosageRequest.administrationRoute
            )

        return if (dosageEntity.isPresent) {
            dosageEntity.get()
        } else {
            dosageRepository.save(dosageRequest.toEntity())
        }
    }
}