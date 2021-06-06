package com.amparo.amparoapi.domain.model.request

import com.amparo.amparoapi.domain.enums.HealthInsuranceType

data class HealthInsuranceRequest(
    val type: HealthInsuranceType,
    val inscription: Int,
    val observation: String?
)