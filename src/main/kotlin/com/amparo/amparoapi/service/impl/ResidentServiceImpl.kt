package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.ResidentEntity
import com.amparo.amparoapi.service.ResidentService
import org.springframework.stereotype.Service

@Service
class ResidentServiceImpl : ResidentService {
    override fun findAll(): List<ResidentEntity> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): ResidentEntity {
        TODO("Not yet implemented")
    }

    override fun create(residentEntity: ResidentEntity) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, residentEntity: ResidentEntity) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}