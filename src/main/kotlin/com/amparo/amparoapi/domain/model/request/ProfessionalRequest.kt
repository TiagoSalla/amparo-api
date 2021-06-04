package com.amparo.amparoapi.domain.model.request

import com.amparo.amparoapi.domain.enums.Gender
import com.amparo.amparoapi.domain.enums.MaritalStatus
import com.amparo.amparoapi.domain.enums.ProfessionalSpecialty
import com.amparo.amparoapi.domain.enums.Race

data class ProfessionalRequest(
    val name: String,
    val socialName: String?,
    val nickname: String?,
    val username: String,
    val password: String,
    val professionalSpecialty: ProfessionalSpecialty,
    val register: String,
    val cpf: String,
    val rg: String,
    val birthDate: String,
    val race: Race,
    val gender: Gender,
    val maritalStatus: MaritalStatus,
    val addressId: Long,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String?
)