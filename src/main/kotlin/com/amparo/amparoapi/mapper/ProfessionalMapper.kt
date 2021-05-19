package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.ProfessionalEntity
import com.amparo.amparoapi.domain.model.request.create.ProfessionalCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ProfessionalUpdateRequest
import com.amparo.amparoapi.domain.model.response.ProfessionalResponse

fun ProfessionalEntity.toResponse() = ProfessionalResponse(
    id = id,
    name = name,
    socialName = socialName,
    nickname = nickname,
    professionalSpecialty = professionalSpecialty,
    register = register,
    cpf = cpf,
    rg = rg,
    birthDate = birthDate,
    race = race,
    gender = gender,
    maritalStatus = maritalStatus,
    address = address.toResponse(),
    email = email,
    mobilePhone = mobilePhone,
    residentialPhone = residentialPhone,
    createdAt = createdAt.toString(),
    updatedAt = updatedAt.toString()
)

fun ProfessionalCreateRequest.toEntity() = ProfessionalEntity(
    name = name,
    socialName = socialName,
    nickname = nickname,
    username = username,
    password = password,
    professionalSpecialty = professionalSpecialty,
    register = register,
    cpf = cpf,
    rg = rg,
    birthDate = birthDate,
    race = race,
    gender = gender,
    maritalStatus = maritalStatus,
    address = address,
    email = email,
    mobilePhone = mobilePhone,
    residentialPhone = residentialPhone
)

fun ProfessionalUpdateRequest.toEntity() = ProfessionalEntity(
    name = name,
    socialName = socialName,
    nickname = nickname,
    username = username,
    password = password,
    professionalSpecialty = professionalSpecialty,
    register = register,
    cpf = cpf,
    rg = rg,
    birthDate = birthDate,
    race = race,
    gender = gender,
    maritalStatus = maritalStatus,
    address = address,
    email = email,
    mobilePhone = mobilePhone,
    residentialPhone = residentialPhone
)
