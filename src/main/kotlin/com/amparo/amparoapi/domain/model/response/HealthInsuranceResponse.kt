package com.amparo.amparoapi.domain.model.response

data class HealthInsuranceResponse(
    val id: Long?,
    val name: String,
    val inscription: Int,
    val observation: String? = null,
    val residentList: List<HealthInsuranceResponse>? = null,
    val createdAt: String,
    val updatedAt: String
)