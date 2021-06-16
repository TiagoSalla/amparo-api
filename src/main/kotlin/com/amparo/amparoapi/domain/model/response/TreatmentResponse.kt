package com.amparo.amparoapi.domain.model.response

data class TreatmentResponse(
    val id: Long,
    val residentId: Long,
    val residentName: String,
    val responsibleProfessional: ProfessionalResponse,
    val medicineList: List<MedicineResponse>,
    val createdAt: String?,
    val updatedAt: String?
)