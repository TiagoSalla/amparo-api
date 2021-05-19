package com.amparo.amparoapi.domain.model.request.update

import com.amparo.amparoapi.domain.model.MedicineEntity
import com.amparo.amparoapi.domain.model.ProfessionalEntity
import com.amparo.amparoapi.domain.model.ResidentEntity

data class TreatmentUpdateRequest(
    val resident: ResidentEntity,
    val responsibleProfessional: ProfessionalEntity,
    val medicineList: List<MedicineEntity>
)