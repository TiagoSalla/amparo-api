package com.amparo.amparoapi.domain.model.request.update

import com.amparo.amparoapi.domain.enums.Gender
import com.amparo.amparoapi.domain.enums.MaritalStatus
import com.amparo.amparoapi.domain.enums.ProfessionalSpecialty
import com.amparo.amparoapi.domain.enums.Race
import com.amparo.amparoapi.domain.model.AddressEntity

data class ProfessionalUpdateRequest(
    val name: String,
    val socialName: String? = null,
    val nickname: String? = null,
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
    val address: AddressEntity,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String? = null
)