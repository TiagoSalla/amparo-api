package com.amparo.amparoapi.domain.model.response

import com.amparo.amparoapi.domain.enums.FederativeUnit

data class AddressResponse(
    val id: Long,
    val streetName: String,
    val district: String,
    val number: Int,
    val observation: String?,
    val zipCode: String,
    val cityName: String,
    val federativeUnit: FederativeUnit,
    val createdAt: String?,
    val updatedAt: String?
)