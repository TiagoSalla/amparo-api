package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.create.DosageCreateRequest
import com.amparo.amparoapi.domain.model.request.update.DosageUpdateRequest
import com.amparo.amparoapi.domain.model.response.DosageResponse

interface DosageService {
    fun findAll(): List<DosageResponse>
    fun findById(id: Long): DosageResponse
    fun create(dosageRequest: DosageCreateRequest)
    fun update(id: Long, dosageRequest: DosageUpdateRequest)
    fun delete(id: Long)
}