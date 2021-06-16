package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.TreatmentRequest
import com.amparo.amparoapi.domain.model.response.TreatmentOptions
import com.amparo.amparoapi.domain.model.response.TreatmentResponse

interface TreatmentService {
    fun findAll(): List<TreatmentResponse>
    fun findById(id: Long): TreatmentResponse
    fun getSelectionOptions(): TreatmentOptions
    fun create(treatmentRequest: TreatmentRequest)
    fun update(id: Long, treatmentRequest: TreatmentRequest)
    fun delete(id: Long)
}