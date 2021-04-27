package com.amparo.amparoapi.domain.model.request.update

data class MedicineUpdateRequest(
    val id: Long,
    val name: String,
    val dosageIdList: List<Long>,
    val laboratory: String,
    val dueDate: String,
    val statusActive: Boolean
)