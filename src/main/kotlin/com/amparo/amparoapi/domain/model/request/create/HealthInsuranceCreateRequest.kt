package com.amparo.amparoapi.domain.model.request.create

data class HealthInsuranceCreateRequest(
    val name: String,
    val inscription: Int,
    val observation: String? = null
)