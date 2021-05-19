package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.HealthInsuranceEntity
import com.amparo.amparoapi.domain.model.request.create.HealthInsuranceCreateRequest
import com.amparo.amparoapi.domain.model.request.update.HealthInsuranceUpdateRequest
import com.amparo.amparoapi.domain.model.response.HealthInsuranceResponse

fun HealthInsuranceEntity.toResponse() = HealthInsuranceResponse(
        id = id,
        name = name,
        inscription = inscription,
        observation = observation,
        createdAt = createdAt.toString(),
        updatedAt = updatedAt.toString()
    )

fun HealthInsuranceCreateRequest.toEntity() = HealthInsuranceEntity(
    name = name,
    inscription = inscription,
    observation = observation
)

fun HealthInsuranceUpdateRequest.toEntity() = HealthInsuranceEntity(
    name = name,
    inscription = inscription,
    observation = observation
)