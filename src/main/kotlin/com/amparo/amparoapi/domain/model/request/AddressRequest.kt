package com.amparo.amparoapi.domain.model.request

import com.amparo.amparoapi.domain.enums.FederativeUnit

data class AddressRequest(
    val streetName: String,
    val district: String,
    val number: Int,
    val observation: String?,
    val zipCode: String,
    val cityName: String,
    val federativeUnit: FederativeUnit
)