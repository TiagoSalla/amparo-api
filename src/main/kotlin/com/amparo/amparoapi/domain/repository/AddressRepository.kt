package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.model.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<AddressEntity, Long>