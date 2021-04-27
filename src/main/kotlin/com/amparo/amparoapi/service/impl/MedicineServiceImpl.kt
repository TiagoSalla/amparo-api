package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.MedicineEntity
import com.amparo.amparoapi.service.MedicineService
import org.springframework.stereotype.Service

@Service
class MedicineServiceImpl : MedicineService {
    override fun findAll(): List<MedicineEntity> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): MedicineEntity {
        TODO("Not yet implemented")
    }

    override fun create(medicineEntity: MedicineEntity) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, medicineEntity: MedicineEntity) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}