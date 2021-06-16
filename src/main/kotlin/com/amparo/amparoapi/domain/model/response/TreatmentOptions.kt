package com.amparo.amparoapi.domain.model.response

data class TreatmentOptions(
    val residentList: List<ResidentResponse>,
    val professionalList: List<ProfessionalResponse>,
    val MedicineList: List<MedicineResponse>
)