package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.ProfessionalEntity
import com.amparo.amparoapi.domain.model.request.ProfessionalRequest
import com.amparo.amparoapi.domain.model.response.ProfessionalResponse
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun ProfessionalEntity.toResponse() = ProfessionalResponse(
    id,
    name,
    socialName,
    nickname,
    professionalSpecialty,
    register,
    cpf,
    rg,
    birthDate,
    race,
    gender,
    maritalStatus,
    address.toResponse(),
    email,
    mobilePhone,
    residentialPhone,
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun ProfessionalRequest.toEntity() = ProfessionalEntity(
    name,
    socialName,
    nickname,
    username,
    password,
    professionalSpecialty,
    register,
    cpf,
    rg,
    birthDate,
    race,
    gender,
    maritalStatus,
    address,
    email,
    mobilePhone,
    residentialPhone
)
