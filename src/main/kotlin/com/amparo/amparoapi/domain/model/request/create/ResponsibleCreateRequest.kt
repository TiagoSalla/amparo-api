package com.amparo.amparoapi.domain.model.request.create

import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.model.ResidentEntity

data class ResponsibleCreateRequest(
    val name: String,
    val socialName: String? = null,
    val cpf: String,
    val rg: String,
    val address: AddressEntity,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String? = null,
    val resident: ResidentEntity
)