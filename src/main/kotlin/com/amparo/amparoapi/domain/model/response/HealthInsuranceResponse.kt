package com.amparo.amparoapi.domain.model.response

import com.amparo.amparoapi.domain.enums.HealthInsuranceType

data class HealthInsuranceResponse(
    val id: Long,
    val healthInsuranceType: HealthInsuranceType,
    val inscription: String,
    val observation: String?,
    val createdAt: String?,
    val updatedAt: String?
)