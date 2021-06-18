package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.DosageEntity
import com.amparo.amparoapi.domain.model.MedicineEntity
import com.amparo.amparoapi.domain.model.request.MedicineRequest
import com.amparo.amparoapi.domain.model.response.MedicineResponse
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val formatterRequestDate = DateTimeFormatter.ofPattern("yyyy-MM-dd")
private val formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun MedicineEntity.toResponse() = MedicineResponse(
    id,
    name,
    dosage.toResponse(),
    laboratory,
    dueDate.toString(),
    statusActive,
    createdAt?.format(formatterDateTime),
    updatedAt?.format(formatterDateTime)
)

fun MedicineRequest.toEntity(dosageEntity: DosageEntity, createdAt: LocalDateTime? = null) = MedicineEntity(
    name,
    dosageEntity,
    laboratory,
    LocalDate.parse(dueDate, formatterRequestDate),
    statusActive,
    createdAt
)