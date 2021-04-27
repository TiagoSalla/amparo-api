package com.amparo.amparoapi.domain.model.request.update

data class ResponsibleUpdateRequest(
    val id: Long,
    val name: String,
    val socialName: String? = null,
    val cpf: String,
    val rg: String,
    val addressId: Long,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String? = null,
    val residentId: Long
)