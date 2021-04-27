package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.DosageEntity

interface ResponsibleService {
    fun findAll(): List<DosageEntity>
    fun findById(id: Long): DosageEntity
    fun create(dosageEntity: DosageEntity)
    fun update(id: Long, dosageEntity: DosageEntity)
    fun delete(id: Long)
}