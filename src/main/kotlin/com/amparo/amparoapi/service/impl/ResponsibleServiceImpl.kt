package com.amparo.amparoapi.service.impl

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
        if (responsible.isPresent) {
            return responsible.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(responsibleRequest: ResponsibleRequest) {
        val addressEntity = addressRepository.findById(responsibleRequest.addressId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        val residentEntity = residentRepository.findById(responsibleRequest.residentId)
            .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
        responsibleRepository.save(responsibleRequest.toEntity(addressEntity, residentEntity))
    }

    override fun update(id: Long, responsibleRequest: ResponsibleRequest) {
        if (responsibleRepository.findById(id).isPresent) {
            val addressEntity = addressRepository.findById(responsibleRequest.addressId)
                .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
            val residentEntity = residentRepository.findById(responsibleRequest.residentId)
                .orElseThrow { HttpClientErrorException(HttpStatus.NOT_FOUND) }
            val responsible = responsibleRequest.toEntity(addressEntity, residentEntity)
            responsible.id = id
            responsibleRepository.save(responsible)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if (responsibleRepository.findById(id).isPresent) {
            responsibleRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}