package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.model.ProfessionalEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfessionalRepository : JpaRepository<ProfessionalEntity, Long>