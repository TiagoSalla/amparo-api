package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.create.MedicineCreateRequest
import com.amparo.amparoapi.domain.model.request.update.MedicineUpdateRequest
import com.amparo.amparoapi.domain.model.response.MedicineResponse

interface MedicineService {
    fun findAll(): List<MedicineResponse>
    fun findById(id: Long): MedicineResponse
    fun create(medicineRequest: MedicineCreateRequest)
    fun update(id: Long, medicineRequest: MedicineUpdateRequest)
    fun delete(id: Long)
}