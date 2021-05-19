package com.amparo.amparoapi.domain.model.request.create

import com.amparo.amparoapi.domain.model.DosageEntity
import java.util.Date

data class MedicineCreateRequest(
    val name: String,
    val dosageList: List<DosageEntity>,
    val laboratory: String,
    val dueDate: Date,
    val statusActive: Boolean = true
)