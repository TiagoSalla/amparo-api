package com.amparo.amparoapi.domain.model.request

data class HealthInsuranceRequest(
    val name: String,
    val inscription: Int,
    val observation: String?
)