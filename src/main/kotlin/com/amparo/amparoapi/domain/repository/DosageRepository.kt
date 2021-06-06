package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.enums.AdministrationRoute
import com.amparo.amparoapi.domain.enums.FrequencyType
import com.amparo.amparoapi.domain.enums.QuantityType
import com.amparo.amparoapi.domain.model.DosageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface DosageRepository : JpaRepository<DosageEntity, Long> {
    fun findByQuantityAndQuantityTypeAndFrequencyAndFrequencyTypeAndAdministrationRoute(
        quantity: Int,
        quantityType: QuantityType,
        frequency: Int,
        frequencyType: FrequencyType,
        administrationRoute: AdministrationRoute
    ): Optional<DosageEntity>
}