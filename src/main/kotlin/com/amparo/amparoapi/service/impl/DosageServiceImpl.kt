package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.DosageEntity
import com.amparo.amparoapi.service.DosageService
import org.springframework.stereotype.Service

@Service
class DosageServiceImpl : DosageService {
    override fun findAll(): List<DosageEntity> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): DosageEntity {
        TODO("Not yet implemented")
    }

    override fun create(dosageEntity: DosageEntity) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, dosageEntity: DosageEntity) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}