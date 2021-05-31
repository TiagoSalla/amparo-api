package com.amparo.amparoapi.domain.model.response

data class AddressResponse(
    val id: Long,
    val streetName: String,
    val district: String,
    val number: Int,
    val observation: String?,
    val zipCode: String,
    val cityName: String,
    val federativeUnit: String,
    val createdAt: String?,
    val updatedAt: String?
)