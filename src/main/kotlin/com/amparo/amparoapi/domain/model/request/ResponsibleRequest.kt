package com.amparo.amparoapi.domain.model.request

import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.model.ResidentEntity

data class ResponsibleRequest(
    val name: String,
    val socialName: String?,
    val cpf: String,
    val rg: String,
    val address: AddressEntity,
    val email: String,
    val mobilePhone: String,
    val residentialPhone: String?,
    val resident: ResidentEntity
)