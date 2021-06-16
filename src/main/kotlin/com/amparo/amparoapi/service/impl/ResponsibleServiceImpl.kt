package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.model.request.AddressRequest
import com.amparo.amparoapi.domain.model.request.ResponsibleRequest
import com.amparo.amparoapi.domain.model.response.ResponsibleResponse
import com.amparo.amparoapi.domain.repository.AddressRepository
import com.amparo.amparoapi.domain.repository.ResidentRepository
import com.amparo.amparoapi.domain.repository.ResponsibleRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.ResponsibleService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class ResponsibleServiceImpl(private val responsibleRepository: ResponsibleRepository,
                                   private val addressRepository: AddressRepository,
                                   private val residentRepository: ResidentRepository) : ResponsibleService {
    override fun findAll(): List<ResponsibleResponse> = responsibleRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): ResponsibleResponse {
        val responsible = responsibleRepository.findById(id)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }

        return responsible.toResponse()
    }

    override fun create(responsibleRequest: ResponsibleRequest) {
        val residentEntity = residentRepository.findById(responsibleRequest.residentId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val addressEntity = findOrCreateAddressEntity(responsibleRequest.address)

        responsibleRepository.save(responsibleRequest.toEntity(addressEntity, residentEntity))
    }

    override fun update(id: Long, responsibleRequest: ResponsibleRequest) {
        val responsible = responsibleRepository.findById(id)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val residentEntity = residentRepository.findById(responsibleRequest.residentId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val addressEntity = findOrCreateAddressEntity(responsibleRequest.address)

        val updatedResponsible = responsibleRequest.toEntity(addressEntity, residentEntity, responsible.createdAt)
        updatedResponsible.id = id
        responsibleRepository.save(updatedResponsible)
    }

    override fun delete(id: Long) {
        responsibleRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }

        responsibleRepository.deleteById(id)
    }

    private fun findOrCreateAddressEntity(addressRequest: AddressRequest): AddressEntity {
        val addressEntity =
            addressRepository.findByStreetNameAndDistrictAndNumberAndObservationAndZipCodeAndCityNameAndFederativeUnit(
                addressRequest.streetName,
                addressRequest.district,
                addressRequest.number,
                addressRequest.observation,
                addressRequest.zipCode,
                addressRequest.cityName,
                addressRequest.federativeUnit
            )

        return if (addressEntity.isPresent) {
            addressEntity.get()
        } else {
            addressRepository.save(addressRequest.toEntity())
        }
    }
}