package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.model.DosageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DosageRepository : JpaRepository<DosageEntity, Long>