package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.ResponsibleEntity
import com.amparo.amparoapi.domain.model.request.create.ResponsibleCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ResponsibleUpdateRequest
import com.amparo.amparoapi.domain.model.response.ResponsibleResponse

fun ResponsibleEntity.toResponse() = ResponsibleResponse(
    id = id,
    name = name,
    socialName = socialName,
    cpf = cpf,
    rg = rg,
    address = address.toResponse(),
    email = email,
    mobilePhone = mobilePhone,
    residentialPhone = residentialPhone,
    resident = resident.toResponse(),
    createdAt = createdAt.toString(),
    updatedAt = updatedAt.toString()
)

fun ResponsibleCreateRequest.toEntity() = ResponsibleEntity(
    name = name,
    socialName = socialName,
    cpf = cpf,
    rg = rg,
    address = address,
    email = email,
    mobilePhone = mobilePhone,
    residentialPhone = residentialPhone,
    resident = resident
)

fun ResponsibleUpdateRequest.toEntity() = ResponsibleEntity(
    name = name,
    socialName = socialName,
    cpf = cpf,
    rg = rg,
    address = address,
    email = email,
    mobilePhone = mobilePhone,
    residentialPhone = residentialPhone,
    resident = resident
)