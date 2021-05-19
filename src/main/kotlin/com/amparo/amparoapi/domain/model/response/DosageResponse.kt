package com.amparo.amparoapi.domain.model.response

import com.amparo.amparoapi.domain.enums.AdministrationRoute
import com.amparo.amparoapi.domain.enums.FrequencyType
import com.amparo.amparoapi.domain.enums.QuantityType

data class DosageResponse(
    val id: Long?,
    val quantity: Int,
    val quantityType: QuantityType,
    val frequency: Int,
    val frequencyType: FrequencyType,
    val administrationRoute: AdministrationRoute,
    val medicineList: List<DosageResponse>? = null,
    val createdAt: String,
    val updatedAt: String
)