package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.HealthInsuranceEntity
import com.amparo.amparoapi.domain.model.request.HealthInsuranceRequest
import com.amparo.amparoapi.domain.model.response.HealthInsuranceResponse
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun HealthInsuranceEntity.toResponse() = HealthInsuranceResponse(
    id,
    name,
    inscription,
    observation,
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun HealthInsuranceRequest.toEntity() = HealthInsuranceEntity(
    name,
    inscription,
    observation
)