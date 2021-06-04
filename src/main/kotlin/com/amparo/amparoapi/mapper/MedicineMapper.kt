package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.DosageEntity
import com.amparo.amparoapi.domain.model.MedicineEntity
import com.amparo.amparoapi.domain.model.request.MedicineRequest
import com.amparo.amparoapi.domain.model.response.MedicineResponse
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun MedicineEntity.toResponse() = MedicineResponse(
    id,
    name,
    dosageList.map { it.toResponse() },
    laboratory,
    dueDate,
    statusActive,
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun MedicineRequest.toEntity(dosageEntityList: List<DosageEntity>) = MedicineEntity(
    name,
    dosageEntityList,
    laboratory,
    dueDate,
    statusActive
)