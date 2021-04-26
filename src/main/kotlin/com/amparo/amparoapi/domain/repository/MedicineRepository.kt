package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.model.MedicineEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MedicineRepository : JpaRepository<MedicineEntity, Long>