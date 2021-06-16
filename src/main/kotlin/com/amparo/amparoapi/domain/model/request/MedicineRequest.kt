package com.amparo.amparoapi.domain.model.request

data class MedicineRequest(
    val name: String,
    val dosage: DosageRequest,
    val laboratory: String,
    val dueDate: String,
    val statusActive: Boolean
)