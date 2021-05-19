package com.amparo.amparoapi.domain.model.request.update

data class AddressUpdateRequest(
    val streetName: String,
    val district: String,
    val number: Int,
    val observation: String? = null,
    val zipCode: String,
    val cityName: String,
    val federativeUnit: String
)