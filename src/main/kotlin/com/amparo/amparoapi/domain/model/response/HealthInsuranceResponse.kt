package com.amparo.amparoapi.domain.model.response

data class HealthInsuranceResponse(
    val id: Long,
    val healthInsuranceType: HealthInsuranceTypeResponse,
    val inscription: String,
    val observation: String?,
    val createdAt: String?,
    val updatedAt: String?
)