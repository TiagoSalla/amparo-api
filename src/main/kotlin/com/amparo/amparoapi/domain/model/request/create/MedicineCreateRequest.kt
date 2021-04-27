package com.amparo.amparoapi.domain.model.request.create

import java.util.Date

data class MedicineCreateRequest(
    val name: String,
    val dosageIdList: List<Long>,
    val laboratory: String,
    val dueDate: Date,
    val statusActive: Boolean = true
)