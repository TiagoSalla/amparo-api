package com.amparo.amparoapi.domain.model.request

import java.util.Date

data class MedicineRequest(
    val name: String,
    val dosageIdList: List<Long>,
    val laboratory: String,
    val dueDate: Date,
    val statusActive: Boolean
)