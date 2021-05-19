package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.DosageEntity
import com.amparo.amparoapi.domain.model.request.create.DosageCreateRequest
import com.amparo.amparoapi.domain.model.request.update.DosageUpdateRequest
import com.amparo.amparoapi.domain.model.response.DosageResponse

fun DosageEntity.toResponse() = DosageResponse(
        id = id,
        quantity = quantity,
        quantityType = quantityType,
        frequency = frequency,
        frequencyType = frequencyType,
        administrationRoute = administrationRoute,
        createdAt = createdAt.toString(),
        updatedAt = updatedAt.toString()
    )

fun DosageCreateRequest.toEntity() = DosageEntity(
    quantity = quantity,
    quantityType = quantityType,
    frequency = frequency,
    frequencyType = frequencyType,
    administrationRoute = administrationRoute
)

fun DosageUpdateRequest.toEntity() = DosageEntity(
    quantity = quantity,
    quantityType = quantityType,
    frequency = frequency,
    frequencyType = frequencyType,
    administrationRoute = administrationRoute
)