package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.ProfessionalEntity
import com.amparo.amparoapi.service.ProfessionalService
import org.springframework.stereotype.Service

@Service
class ProfessionalServiceImpl : ProfessionalService {
    override fun findAll(): List<ProfessionalEntity> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): ProfessionalEntity {
        TODO("Not yet implemented")
    }

    override fun create(professionalEntity: ProfessionalEntity) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, professionalEntity: ProfessionalEntity) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}