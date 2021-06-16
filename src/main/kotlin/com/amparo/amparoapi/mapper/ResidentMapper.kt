package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.HealthInsuranceEntity
import com.amparo.amparoapi.domain.model.ResidentEntity
import com.amparo.amparoapi.domain.model.request.ResidentRequest
import com.amparo.amparoapi.domain.model.response.ResidentResponse
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter

private val formatterRequestDate = DateTimeFormatter.ofPattern("yyyy-MM-dd")
private val formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

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
    birthDate.toString(),
    Period.between(birthDate, LocalDate.now()).years,
    healthInsurance.toResponse(),
    responsible?.toResponse(),
    treatment?.toResponse(),
    createdAt?.format(formatterDateTime),
    updatedAt?.format(formatterDateTime)
)

fun ResidentRequest.toEntity(healthInsuranceEntity: HealthInsuranceEntity, createdAt: LocalDateTime? = null) =
    ResidentEntity(
        name,
        socialName,
        nickname,
        cpf,
        rg,
        race,
        gender,
        maritalStatus,
        LocalDate.parse(birthDate, formatterRequestDate),
        healthInsuranceEntity,
        createdAt
    )