package com.amparo.amparoapi.domain.repository

import com.amparo.amparoapi.domain.enums.FederativeUnit
import com.amparo.amparoapi.domain.model.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AddressRepository : JpaRepository<AddressEntity, Long> {
    fun findByStreetNameAndDistrictAndNumberAndObservationAndZipCodeAndCityNameAndFederativeUnit(
        streetName: String,
        district: String,
        number: Int,
        observation: String?,
        zipCode: String,
        cityName: String,
        federativeUnit: FederativeUnit
    ): Optional<AddressEntity>
}