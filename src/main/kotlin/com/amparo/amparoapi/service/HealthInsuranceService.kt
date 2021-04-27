package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.DosageEntity
import com.amparo.amparoapi.domain.model.HealthInsuranceEntity

interface HealthInsuranceService {
    fun findAll(): List<HealthInsuranceEntity>
    fun findById(id: Long): HealthInsuranceEntity
    fun create(healthInsuranceEntity: HealthInsuranceEntity)
    fun update(id: Long, healthInsuranceEntity: HealthInsuranceEntity)
    fun delete(id: Long)
}