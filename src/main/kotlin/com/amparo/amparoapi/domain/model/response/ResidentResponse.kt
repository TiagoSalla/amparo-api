package com.amparo.amparoapi.domain.model.response

import com.amparo.amparoapi.domain.enums.Gender
import com.amparo.amparoapi.domain.enums.MaritalStatus
import com.amparo.amparoapi.domain.enums.Race

data class ResidentResponse(
    val id: Long?,
    val name: String,
    val socialName: String? = null,
    val nickname: String? = null,
    val cpf: String,
    val rg: String,
    val race: Race,
    val gender: Gender,
    val maritalStatus: MaritalStatus,
    val birthDate: String,
    val healthInsurance: HealthInsuranceResponse,
    val responsibleList: List<ResponsibleResponse>? = null,
    val treatment: TreatmentResponse? = null,
    val createdAt: String,
    val updatedAt: String
)