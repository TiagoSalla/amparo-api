package com.amparo.amparoapi.domain.model.request.create

import com.amparo.amparoapi.domain.enums.AdministrationRoute
import com.amparo.amparoapi.domain.enums.FrequencyType
import com.amparo.amparoapi.domain.enums.QuantityType

data class DosageCreateRequest(
    val quantity: Int,
    val quantityType: QuantityType,
    val frequency: Int,
    val frequencyType: FrequencyType,
    val administrationRoute: AdministrationRoute
)