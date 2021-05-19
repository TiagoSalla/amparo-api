package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.create.ProfessionalCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ProfessionalUpdateRequest
import com.amparo.amparoapi.domain.model.response.ProfessionalResponse
import com.amparo.amparoapi.domain.repository.ProfessionalRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.ProfessionalService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class ProfessionalServiceImpl(private val professionalRepository: ProfessionalRepository) : ProfessionalService {
    override fun findAll(): List<ProfessionalResponse> = professionalRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): ProfessionalResponse {
        val professional = professionalRepository.findById(id)
        if(professional.isPresent) {
            return professional.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(professionalRequest: ProfessionalCreateRequest) {
        professionalRepository.save(professionalRequest.toEntity())
    }

    override fun update(id: Long, professionalRequest: ProfessionalUpdateRequest) {
        if(professionalRepository.findById(id).isPresent) {
            val professional = professionalRequest.toEntity()
            professional.id = id
            professionalRepository.save(professional)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if(professionalRepository.findById(id).isPresent) {
            professionalRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}