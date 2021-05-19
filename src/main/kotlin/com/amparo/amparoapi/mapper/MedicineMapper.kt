package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.MedicineEntity
import com.amparo.amparoapi.domain.model.request.create.MedicineCreateRequest
import com.amparo.amparoapi.domain.model.request.update.MedicineUpdateRequest
import com.amparo.amparoapi.domain.model.response.MedicineResponse

fun MedicineEntity.toResponse() = MedicineResponse(
    id = id,
    name = name,
    dosageList = dosageList.map { it.toResponse() },
    laboratory = laboratory,
    dueDate = dueDate,
    statusActive = statusActive,
    createdAt = createdAt.toString(),
    updatedAt = updatedAt.toString()
)

fun MedicineCreateRequest.toEntity() = MedicineEntity(
    name = name,
    dosageList = dosageList,
    laboratory = laboratory,
    dueDate = dueDate,
    statusActive = statusActive
)

fun MedicineUpdateRequest.toEntity() = MedicineEntity(
    name = name,
    dosageList = dosageList,
    laboratory = laboratory,
    dueDate = dueDate,
    statusActive = statusActive
)