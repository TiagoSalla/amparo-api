package com.amparo.amparoapi.domain.model.request.create

data class TreatmentCreateRequest(
    val residentId: Long,
    val responsibleProfessionalId: Long,
    val medicineIdList: List<Long>
)