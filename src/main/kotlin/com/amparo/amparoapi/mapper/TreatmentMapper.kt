package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.TreatmentEntity
import com.amparo.amparoapi.domain.model.request.TreatmentRequest
import com.amparo.amparoapi.domain.model.response.TreatmentResponse
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun TreatmentEntity.toResponse() = TreatmentResponse(
    id,
    resident.toResponse(),
    responsibleProfessional.toResponse(),
    medicineList.map { it.toResponse() },
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun TreatmentRequest.toEntity() = TreatmentEntity(
    resident,
    responsibleProfessional,
    medicineList
)