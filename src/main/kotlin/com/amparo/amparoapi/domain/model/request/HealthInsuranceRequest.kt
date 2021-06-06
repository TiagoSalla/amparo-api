package com.amparo.amparoapi.domain.model.request

data class HealthInsuranceRequest(
    val healthInsuranceRawValue: String,
    val inscription: Int,
    val observation: String?
)