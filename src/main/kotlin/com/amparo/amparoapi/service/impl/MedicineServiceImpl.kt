package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.create.MedicineCreateRequest
import com.amparo.amparoapi.domain.model.request.update.MedicineUpdateRequest
import com.amparo.amparoapi.domain.model.response.MedicineResponse
import com.amparo.amparoapi.domain.repository.MedicineRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.MedicineService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class MedicineServiceImpl(private val medicineRepository: MedicineRepository) : MedicineService {
    override fun findAll(): List<MedicineResponse> = medicineRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): MedicineResponse {
        val medicine = medicineRepository.findById(id)
        if(medicine.isPresent) {
            return medicine.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(medicineRequest: MedicineCreateRequest) {
        medicineRepository.save(medicineRequest.toEntity())
    }

    override fun update(id: Long, medicineRequest: MedicineUpdateRequest) {
        if(medicineRepository.findById(id).isPresent) {
            val medicine = medicineRequest.toEntity()
            medicine.id = id
            medicineRepository.save(medicine)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if(medicineRepository.findById(id).isPresent) {
            medicineRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}