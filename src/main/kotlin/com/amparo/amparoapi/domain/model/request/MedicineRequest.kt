package com.amparo.amparoapi.domain.model.request

import com.amparo.amparoapi.domain.model.DosageEntity
import java.util.Date

data class MedicineRequest(
    val name: String,
    val dosageList: List<DosageEntity>,
    val laboratory: String,
    val dueDate: Date,
    val statusActive: Boolean
)