package com.amparo.amparoapi.domain.model.request.create

data class ResponsibleCreateRequest(
    val name: String,
    val socialName: String? = null,
    val cpf: String,
    val rg: String,
    val address: Long,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String? = null,
    val residentId: Long
)