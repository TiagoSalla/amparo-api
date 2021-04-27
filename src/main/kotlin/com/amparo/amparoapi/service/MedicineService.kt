package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.MedicineEntity

interface MedicineService {
    fun findAll(): List<MedicineEntity>
    fun findById(id: Long): MedicineEntity
    fun create(medicineEntity: MedicineEntity)
    fun update(id: Long, medicineEntity: MedicineEntity)
    fun delete(id: Long)
}