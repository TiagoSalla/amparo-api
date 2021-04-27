package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.TreatmentEntity
import com.amparo.amparoapi.service.TreatmentService
import org.springframework.stereotype.Service

@Service
class TreatmentServiceImpl : TreatmentService {
    override fun findAll(): List<TreatmentEntity> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): TreatmentEntity {
        TODO("Not yet implemented")
    }

    override fun create(treatmentEntity: TreatmentEntity) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, treatmentEntity: TreatmentEntity) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}