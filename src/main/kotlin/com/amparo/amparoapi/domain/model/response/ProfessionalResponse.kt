package com.amparo.amparoapi.domain.model.response

import com.amparo.amparoapi.domain.enums.Gender
import com.amparo.amparoapi.domain.enums.MaritalStatus
import com.amparo.amparoapi.domain.enums.ProfessionalSpecialty
import com.amparo.amparoapi.domain.enums.Race

data class ProfessionalResponse(
    val id: Long,
    val name: String,
    val socialName: String?,
    val nickname: String?,
    val professionalSpecialty: ProfessionalSpecialty,
    val register: String,
    val cpf: String,
    val rg: String,
    val birthDate: String,
    val age: Int,
    val race: Race,
    val gender: Gender,
    val maritalStatus: MaritalStatus,
    val address: AddressResponse,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String?,
    val createdAt: String?,
    val updatedAt: String?
)