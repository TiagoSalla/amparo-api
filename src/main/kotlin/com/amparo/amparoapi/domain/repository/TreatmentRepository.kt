package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.model.TreatmentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TreatmentRepository : JpaRepository<TreatmentEntity, Long>