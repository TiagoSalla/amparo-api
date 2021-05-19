package com.amparo.amparoapi.domain.model.request.update

import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.model.ResidentEntity

data class ResponsibleUpdateRequest(
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