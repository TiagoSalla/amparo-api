package com.amparo.amparoapi.domain.model.request.create

import com.amparo.amparoapi.domain.model.MedicineEntity
import com.amparo.amparoapi.domain.model.ProfessionalEntity
import com.amparo.amparoapi.domain.model.ResidentEntity

data class TreatmentCreateRequest(
    val resident: ResidentEntity,
    val responsibleProfessional: ProfessionalEntity,
    val medicineList: List<MedicineEntity>
)