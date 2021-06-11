package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.model.ProfessionalEntity
import com.amparo.amparoapi.domain.model.request.ProfessionalRequest
import com.amparo.amparoapi.domain.model.response.ProfessionalResponse
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter

private val formatterRequestDate = DateTimeFormatter.ofPattern("yyyy-MM-dd")
private val formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun ProfessionalEntity.toResponse() = ProfessionalResponse(
    id,
    name,
    socialName,
    nickname,
    professionalSpecialty,
    register,
    cpf,
    rg,
    birthDate.toString(),
    Period.between(birthDate, LocalDate.now()).years,
    race,
    gender,
    maritalStatus,
    address.toResponse(),
    email,
    mobilePhone,
    residentialPhone,
    createdAt?.format(formatterDateTime),
    updatedAt?.format(formatterDateTime)
)

fun ProfessionalRequest.toEntity(addressEntity: AddressEntity, createdAt: LocalDateTime? = null) = ProfessionalEntity(
    name,
    socialName,
    nickname,
    username,
    password,
    professionalSpecialty,
    register,
    cpf,
    rg,
    LocalDate.parse(birthDate, formatterRequestDate),
    race,
    gender,
    maritalStatus,
    addressEntity,
    email,
    mobilePhone,
    residentialPhone,
    createdAt
)
