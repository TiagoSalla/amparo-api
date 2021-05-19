package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.TreatmentEntity
import com.amparo.amparoapi.domain.model.request.create.TreatmentCreateRequest
import com.amparo.amparoapi.domain.model.request.update.TreatmentUpdateRequest
import com.amparo.amparoapi.domain.model.response.TreatmentResponse

fun TreatmentEntity.toResponse() = TreatmentResponse(
        id = id,
        resident = resident.toResponse(),
        responsibleProfessional = responsibleProfessional.toResponse(),
        medicineList = medicineList.map { it.toResponse() },
        createdAt = createdAt.toString(),
        updatedAt = updatedAt.toString()
    )

fun TreatmentCreateRequest.toEntity() = TreatmentEntity(
    resident = resident,
    responsibleProfessional = responsibleProfessional,
    medicineList = medicineList
)

fun TreatmentUpdateRequest.toEntity() = TreatmentEntity(
    resident = resident,
    responsibleProfessional = responsibleProfessional,
    medicineList = medicineList
)