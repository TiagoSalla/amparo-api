package com.amparo.amparoapi.domain.model.request.update

data class TreatmentUpdateRequest(
    val id: Long,
    val residentId: Long,
    val responsibleProfessionalId: Long,
    val medicineIdList: List<Long>
)