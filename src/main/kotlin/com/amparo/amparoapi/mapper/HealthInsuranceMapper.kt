package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.enums.HealthInsuranceType
import com.amparo.amparoapi.domain.model.HealthInsuranceEntity
import com.amparo.amparoapi.domain.model.request.HealthInsuranceRequest
import com.amparo.amparoapi.domain.model.response.HealthInsuranceResponse
import com.amparo.amparoapi.domain.model.response.HealthInsuranceTypeResponse
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun HealthInsuranceEntity.toResponse() = HealthInsuranceResponse(
    id,
    HealthInsuranceTypeResponse(healthInsuranceType.name, healthInsuranceType.description),
    inscription,
    observation,
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun HealthInsuranceRequest.toEntity(createdAt: LocalDateTime? = null) = HealthInsuranceEntity(
    HealthInsuranceType.valueOf(healthInsuranceRawValue),
    inscription,
    observation,
    createdAt
)