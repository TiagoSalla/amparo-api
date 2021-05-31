package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.ResponsibleRequest
import com.amparo.amparoapi.domain.model.response.ResponsibleResponse
import com.amparo.amparoapi.domain.repository.ResponsibleRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.ResponsibleService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class ResponsibleServiceImpl(private val responsibleRepository: ResponsibleRepository) : ResponsibleService {
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
        responsibleRepository.save(responsibleRequest.toEntity())
    }

    override fun update(id: Long, responsibleRequest: ResponsibleRequest) {
        if (responsibleRepository.findById(id).isPresent) {
            val responsible = responsibleRequest.toEntity()
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