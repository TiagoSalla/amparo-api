package com.amparo.amparoapi.mapper

import com.amparo.amparoapi.domain.model.MedicineEntity
import com.amparo.amparoapi.domain.model.ProfessionalEntity
import com.amparo.amparoapi.domain.model.ResidentEntity
import com.amparo.amparoapi.domain.model.TreatmentEntity
import com.amparo.amparoapi.domain.model.request.TreatmentRequest
import com.amparo.amparoapi.domain.model.response.TreatmentResponse
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

fun TreatmentEntity.toResponse() = TreatmentResponse(
    id,
    resident.id,
    resident.name,
    responsibleProfessional.toResponse(),
    medicineList.map { it.toResponse() },
    createdAt?.format(formatter),
    updatedAt?.format(formatter)
)

fun TreatmentRequest.toEntity(residentEntity: ResidentEntity,
                              professionalEntity: ProfessionalEntity,
                              medicineEntityList: List<MedicineEntity>,
                              createdAt: LocalDateTime? = null) = TreatmentEntity(
    residentEntity,
    professionalEntity,
    medicineEntityList,
    createdAt
)