package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.model.ResponsibleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResponsibleRepository : JpaRepository<ResponsibleEntity, Long>