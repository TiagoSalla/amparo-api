package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.model.ResidentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResidentRepository : JpaRepository<ResidentEntity, Long>