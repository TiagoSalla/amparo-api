package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.MedicineRequest
import com.amparo.amparoapi.domain.model.response.MedicineResponse

interface MedicineService {
    fun findAll(): List<MedicineResponse>
    fun findById(id: Long): MedicineResponse
    fun create(medicineRequest: MedicineRequest)
    fun update(id: Long, medicineRequest: MedicineRequest)
    fun delete(id: Long)
}