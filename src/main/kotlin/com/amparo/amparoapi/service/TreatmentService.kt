package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.create.TreatmentCreateRequest
import com.amparo.amparoapi.domain.model.request.update.TreatmentUpdateRequest
import com.amparo.amparoapi.domain.model.response.TreatmentResponse

interface TreatmentService {
    fun findAll(): List<TreatmentResponse>
    fun findById(id: Long): TreatmentResponse
    fun create(treatmentRequest: TreatmentCreateRequest)
    fun update(id: Long, treatmentRequest: TreatmentUpdateRequest)
    fun delete(id: Long)
}