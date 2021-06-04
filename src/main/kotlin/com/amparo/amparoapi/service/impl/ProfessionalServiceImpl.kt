package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.LoginRequest
import com.amparo.amparoapi.domain.model.request.ProfessionalRequest
import com.amparo.amparoapi.domain.model.response.ProfessionalResponse
import com.amparo.amparoapi.domain.repository.AddressRepository
import com.amparo.amparoapi.domain.repository.ProfessionalRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.ProfessionalService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class ProfessionalServiceImpl(private val professionalRepository: ProfessionalRepository,
                                    private val addressRepository: AddressRepository) : ProfessionalService {
    override fun findAll(): List<ProfessionalResponse> = professionalRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): ProfessionalResponse {
        val professional = professionalRepository.findById(id)
        if (professional.isPresent) {
            return professional.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(professionalRequest: ProfessionalRequest) {
        val addressEntity = addressRepository.findById(professionalRequest.addressId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        professionalRepository.save(professionalRequest.toEntity(addressEntity))
    }

    override fun update(id: Long, professionalRequest: ProfessionalRequest) {
        if (professionalRepository.findById(id).isPresent) {
            val addressEntity = addressRepository.findById(professionalRequest.addressId)
                .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
            val professional = professionalRequest.toEntity(addressEntity)
            professional.id = id
            professionalRepository.save(professional)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if (professionalRepository.findById(id).isPresent) {
            professionalRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun login(loginRequest: LoginRequest) {
        if (!professionalRepository.existsByUsernameAndPassword(loginRequest.username, loginRequest.password)) {
            throw HttpClientErrorException(HttpStatus.UNAUTHORIZED)
        }
    }
}