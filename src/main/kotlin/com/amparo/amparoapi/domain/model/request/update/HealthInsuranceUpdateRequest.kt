package com.amparo.amparoapi.domain.model.request.update

data class HealthInsuranceUpdateRequest(
    val id: Long,
    val name: String,
    val inscription: Int,
    val observation: String? = null
)