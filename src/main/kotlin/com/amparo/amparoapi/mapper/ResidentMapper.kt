package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.ResidentEntity
import com.amparo.amparoapi.domain.model.request.create.ResidentCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ResidentUpdateRequest
import com.amparo.amparoapi.domain.model.response.ResidentResponse

fun ResidentEntity.toResponse() = ResidentResponse(
    id = id,
    name = name,
    socialName = socialName,
    nickname = nickname,
    cpf = cpf,
    rg = rg,
    race = race,
    gender = gender,
    maritalStatus = maritalStatus,
    birthDate = birthDate,
    healthInsurance = healthInsurance.toResponse(),
    createdAt = createdAt.toString(),
    updatedAt = updatedAt.toString()
)

fun ResidentCreateRequest.toEntity() = ResidentEntity(
    name = name,
    socialName = socialName,
    nickname = nickname,
    cpf = cpf,
    rg = rg,
    race = race,
    gender = gender,
    maritalStatus = maritalStatus,
    birthDate = birthDate,
    healthInsurance = healthInsurance
)

fun ResidentUpdateRequest.toEntity() = ResidentEntity(
    name = name,
    socialName = socialName,
    nickname = nickname,
    cpf = cpf,
    rg = rg,
    race = race,
    gender = gender,
    maritalStatus = maritalStatus,
    birthDate = birthDate,
    healthInsurance = healthInsurance
)