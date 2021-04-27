package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.ResidentEntity

interface ResidentService {
    fun findAll(): List<ResidentEntity>
    fun findById(id: Long): ResidentEntity
    fun create(residentEntity: ResidentEntity)
    fun update(id: Long, residentEntity: ResidentEntity)
    fun delete(id: Long)
}