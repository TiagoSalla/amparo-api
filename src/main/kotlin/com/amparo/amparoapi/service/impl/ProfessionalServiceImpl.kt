package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.model.request.AddressRequest
import com.amparo.amparoapi.domain.model.request.LoginRequest
import com.amparo.amparoapi.domain.model.request.ProfessionalRequest
import com.amparo.amparoapi.domain.model.response.ProfessionalResponse
import com.amparo.amparoapi.domain.repository.AddressRepository
import com.amparo.amparoapi.domain.repository.ProfessionalRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.ProfessionalService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class ProfessionalServiceImpl(private val professionalRepository: ProfessionalRepository,
                                    private val addressRepository: AddressRepository) : ProfessionalService {
    override fun findAll(): List<ProfessionalResponse> = professionalRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): ProfessionalResponse {
        val professional = professionalRepository.findById(id)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        return professional.toResponse()
    }

    override fun create(professionalRequest: ProfessionalRequest) {
        val addressEntity = findOrCreateAddressEntity(professionalRequest.address)
        professionalRepository.save(professionalRequest.toEntity(addressEntity))
    }

    override fun update(id: Long, professionalRequest: ProfessionalRequest) {
        val professional = professionalRepository.findById(id)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val addressEntity = findOrCreateAddressEntity(professionalRequest.address)
        val updatedProfessional = professionalRequest.toEntity(addressEntity, professional.createdAt)
        updatedProfessional.id = id
        professionalRepository.save(updatedProfessional)
    }

    override fun delete(id: Long) {
        professionalRepository.findById(id).orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        professionalRepository.deleteById(id)
    }

    override fun login(loginRequest: LoginRequest) {
        if (!professionalRepository.existsByUsernameAndPassword(loginRequest.username, loginRequest.password)) {
            throw HttpClientErrorException(HttpStatus.UNAUTHORIZED)
        }
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