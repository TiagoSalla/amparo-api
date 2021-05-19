package com.amparo.amparoapi.domain.model.response

import java.util.Date

data class MedicineResponse(
    val id: Long?,
    val name: String,
    val dosageList: List<DosageResponse>,
    val laboratory: String,
    val dueDate: Date,
    val statusActive: Boolean,
    val treatmentList: List<TreatmentResponse>? = null,
    val createdAt: String,
    val updatedAt: String
)