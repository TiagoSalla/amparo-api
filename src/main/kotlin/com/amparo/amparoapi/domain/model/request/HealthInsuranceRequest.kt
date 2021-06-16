package com.amparo.amparoapi.domain.model.request

data class HealthInsuranceRequest(
    val healthInsuranceRawValue: String,
    val inscription: String,
    val observation: String?
)