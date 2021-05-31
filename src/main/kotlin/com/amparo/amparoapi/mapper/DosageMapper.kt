package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.DosageEntity
import com.amparo.amparoapi.domain.model.request.DosageRequest
import com.amparo.amparoapi.domain.model.response.DosageResponse
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun DosageEntity.toResponse() = DosageResponse(
    id,
    quantity,
    quantityType,
    frequency,
    frequencyType,
    administrationRoute,
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun DosageRequest.toEntity() = DosageEntity(
    quantity,
    quantityType,
    frequency,
    frequencyType,
    administrationRoute
)