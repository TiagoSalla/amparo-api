package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.enums.HealthInsuranceType
import com.amparo.amparoapi.domain.model.HealthInsuranceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface HealthInsuranceRepository : JpaRepository<HealthInsuranceEntity, Long> {
    fun findByHealthInsuranceTypeAndInscriptionAndObservation(
        healthInsuranceType: HealthInsuranceType,
        inscription: Int,
        observation: String?
    ): Optional<HealthInsuranceEntity>
}