package com.amparo.amparoapi.domain.model.request.create

data class AddressCreateRequest(
    val streetName: String,
    val district: String,
    val number: Int,
    val observation: String? = null,
    val zipCode: String,
    val cityName: String,
    val federativeUnit: String
)