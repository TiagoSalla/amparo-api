package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.model.ResidentEntity
import com.amparo.amparoapi.domain.model.ResponsibleEntity
import com.amparo.amparoapi.domain.model.request.ResponsibleRequest
import com.amparo.amparoapi.domain.model.response.ResponsibleResponse
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun ResponsibleEntity.toResponse() = ResponsibleResponse(
    id,
    name,
    socialName,
    cpf,
    rg,
    address.toResponse(),
    email,
    mobilePhone,
    residentialPhone,
    resident.id,
    resident.name,
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun ResponsibleRequest.toEntity(addressEntity: AddressEntity, residentEntity: ResidentEntity) = ResponsibleEntity(
    name,
    socialName,
    cpf,
    rg,
    addressEntity,
    email,
    mobilePhone,
    residentialPhone,
    residentEntity
)