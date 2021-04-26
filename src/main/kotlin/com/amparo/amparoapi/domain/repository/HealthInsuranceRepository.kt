package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.model.HealthInsuranceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HealthInsuranceRepository : JpaRepository<HealthInsuranceEntity, Long>