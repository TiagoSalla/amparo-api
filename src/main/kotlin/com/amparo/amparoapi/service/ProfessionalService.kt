package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.ProfessionalEntity

interface ProfessionalService {
    fun findAll(): List<ProfessionalEntity>
    fun findById(id: Long): ProfessionalEntity
    fun create(professionalEntity: ProfessionalEntity)
    fun update(id: Long, professionalEntity: ProfessionalEntity)
    fun delete(id: Long)
}