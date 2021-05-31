package com.amparo.amparoapi.domain.model.request

data class AddressRequest(
    val streetName: String,
    val district: String,
    val number: Int,
    val observation: String?,
    val zipCode: String,
    val cityName: String,
    val federativeUnit: String
)