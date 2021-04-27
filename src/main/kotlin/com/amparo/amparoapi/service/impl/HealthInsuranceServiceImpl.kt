package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.HealthInsuranceEntity
import com.amparo.amparoapi.service.HealthInsuranceService
import org.springframework.stereotype.Service

@Service
class HealthInsuranceServiceImpl : HealthInsuranceService {
    override fun findAll(): List<HealthInsuranceEntity> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): HealthInsuranceEntity {
        TODO("Not yet implemented")
    }

    override fun create(healthInsuranceEntity: HealthInsuranceEntity) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, healthInsuranceEntity: HealthInsuranceEntity) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}