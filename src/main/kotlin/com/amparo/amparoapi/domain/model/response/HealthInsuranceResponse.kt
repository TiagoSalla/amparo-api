package com.amparo.amparoapi.domain.model.response

import com.amparo.amparoapi.domain.enums.HealthInsuranceType

data class HealthInsuranceResponse(
    val id: Long,
    val type: HealthInsuranceType,
    val inscription: Int,
    val observation: String?,
    val createdAt: String?,
    val updatedAt: String?
)