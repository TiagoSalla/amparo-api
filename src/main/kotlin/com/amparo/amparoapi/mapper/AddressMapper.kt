package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.enums.FederativeUnit
import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.model.request.create.AddressCreateRequest
import com.amparo.amparoapi.domain.model.request.update.AddressUpdateRequest
import com.amparo.amparoapi.domain.model.response.AddressResponse

fun AddressEntity.toResponse() = AddressResponse(
        id = id,
        streetName = streetName,
        district = district,
        number = number,
        observation = observation,
        zipCode = zipCode,
        cityName = cityName,
        federativeUnit = federativeUnit.name,
        createdAt = createdAt.toString(),
        updatedAt = updatedAt.toString()
    )

fun AddressCreateRequest.toEntity() = AddressEntity(
    streetName = streetName,
    district = district,
    number = number,
    observation = observation,
    zipCode = zipCode,
    cityName = cityName,
    federativeUnit = FederativeUnit.valueOf(federativeUnit)
)

fun AddressUpdateRequest.toEntity() = AddressEntity(
    streetName = streetName,
    district = district,
    number = number,
    observation = observation,
    zipCode = zipCode,
    cityName = cityName,
    federativeUnit = FederativeUnit.valueOf(federativeUnit)
)