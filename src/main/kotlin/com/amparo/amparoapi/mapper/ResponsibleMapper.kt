package com.amparo.amparoapi.mapper

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
    resident.toResponse(),
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun ResponsibleRequest.toEntity() = ResponsibleEntity(
    name,
    socialName,
    cpf,
    rg,
    address,
    email,
    mobilePhone,
    residentialPhone,
    resident
)