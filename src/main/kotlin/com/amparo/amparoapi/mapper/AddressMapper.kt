package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.enums.FederativeUnit
import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.model.request.AddressRequest
import com.amparo.amparoapi.domain.model.response.AddressResponse
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun AddressEntity.toResponse() = AddressResponse(
    id,
    streetName,
    district,
    number,
    observation,
    zipCode,
    cityName,
    federativeUnit.name,
    createdAt?.format(formatter),
    updatedAt?.format(formatter),
)

fun AddressRequest.toEntity(createdAt: LocalDateTime? = null) = AddressEntity(
    streetName,
    district,
    number,
    observation,
    zipCode,
    cityName,
    federativeUnit,
    createdAt
)