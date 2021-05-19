package com.amparo.amparoapi.domain.model.response

data class ResponsibleResponse(
    val id: Long?,
    val name: String,
    val socialName: String? = null,
    val cpf: String,
    val rg: String,
    val address: AddressResponse,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String? = null,
    val resident: ResidentResponse,
    val createdAt: String,
    val updatedAt: String
)