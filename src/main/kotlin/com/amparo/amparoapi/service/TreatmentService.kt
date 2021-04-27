package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.TreatmentEntity

interface TreatmentService {
    fun findAll(): List<TreatmentEntity>
    fun findById(id: Long): TreatmentEntity
    fun create(treatmentEntity: TreatmentEntity)
    fun update(id: Long, treatmentEntity: TreatmentEntity)
    fun delete(id: Long)
}