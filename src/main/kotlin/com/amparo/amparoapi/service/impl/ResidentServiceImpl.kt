package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.create.ResidentCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ResidentUpdateRequest
import com.amparo.amparoapi.domain.model.response.ResidentResponse
import com.amparo.amparoapi.domain.repository.ResidentRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.ResidentService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class ResidentServiceImpl(private val residentRepository: ResidentRepository) : ResidentService {
    override fun findAll(): List<ResidentResponse> = residentRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): ResidentResponse {
        val resident = residentRepository.findById(id)
        if(resident.isPresent) {
            return resident.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(residentRequest: ResidentCreateRequest) {
        residentRepository.save(residentRequest.toEntity())
    }

    override fun update(id: Long, residentRequest: ResidentUpdateRequest) {
        if(residentRepository.findById(id).isPresent) {
            val resident = residentRequest.toEntity()
            resident.id = id
            residentRepository.save(resident)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if(residentRepository.findById(id).isPresent) {
            residentRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}