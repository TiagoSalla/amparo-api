package com.amparo.amparoapi.domain.model.response

data class MedicineResponse(
    val id: Long,
    val name: String,
    val dosage: DosageResponse,
    val laboratory: String,
    val dueDate: String,
    val statusActive: Boolean,
    val createdAt: String?,
    val updatedAt: String?
)