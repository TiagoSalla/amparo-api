package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.DosageRequest
import com.amparo.amparoapi.domain.model.response.DosageResponse

interface DosageService {
    fun findAll(): List<DosageResponse>
    fun findById(id: Long): DosageResponse
    fun create(dosageRequest: DosageRequest)
    fun update(id: Long, dosageRequest: DosageRequest)
    fun delete(id: Long)
}