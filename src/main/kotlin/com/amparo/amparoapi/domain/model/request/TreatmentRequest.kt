package com.amparo.amparoapi.domain.model.request

data class TreatmentRequest(
    val residentId: Long,
    val responsibleProfessionalId: Long,
    val medicineIdList: List<Long>
)