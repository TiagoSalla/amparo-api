package com.amparo.amparoapi.domain.model.response

data class ResponsibleResponse(
    val id: Long,
    val name: String,
    val socialName: String?,
    val cpf: String,
    val rg: String,
    val address: AddressResponse,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String?,
    val resident: ResidentResponse,
    val createdAt: String?,
    val updatedAt: String?
)