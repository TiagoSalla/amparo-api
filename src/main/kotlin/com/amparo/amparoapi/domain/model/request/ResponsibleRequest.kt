package com.amparo.amparoapi.domain.model.request

data class ResponsibleRequest(
    val name: String,
    val socialName: String?,
    val cpf: String,
    val rg: String,
    val address: AddressRequest,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String?,
    val residentId: Long
)