package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.HealthInsuranceEntity
import com.amparo.amparoapi.domain.model.ResidentEntity
import com.amparo.amparoapi.domain.model.request.ResidentRequest
import com.amparo.amparoapi.domain.model.response.ResidentResponse
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun ResidentEntity.toResponse() = ResidentResponse(
    id,
    name,
    socialName,
    nickname,
    cpf,
    rg,
    race,
    gender,
    maritalStatus,
    birthDate,
    healthInsurance.toResponse(),
    responsibleList?.map { it.toResponse() },
    treatment?.toResponse(),
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun ResidentRequest.toEntity(healthInsuranceEntity: HealthInsuranceEntity) = ResidentEntity(
    name,
    socialName,
    nickname,
    cpf,
    rg,
    race,
    gender,
    maritalStatus,
    birthDate,
    healthInsuranceEntity
)