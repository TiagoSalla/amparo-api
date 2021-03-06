package com.amparo.amparoapi.domain.model.request

import com.amparo.amparoapi.domain.enums.Gender
import com.amparo.amparoapi.domain.enums.MaritalStatus
import com.amparo.amparoapi.domain.enums.Race

data class ResidentRequest(
    val name: String,
    val socialName: String? = null,
    val nickname: String? = null,
    val cpf: String,
    val rg: String,
    val race: Race,
    val gender: Gender,
    val maritalStatus: MaritalStatus,
    val birthDate: String,
    val healthInsurance: HealthInsuranceRequest
)