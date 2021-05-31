package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.request.AddressRequest
import com.amparo.amparoapi.domain.model.response.AddressResponse
import com.amparo.amparoapi.domain.repository.AddressRepository
import com.amparo.amparoapi.mapper.toEntity
import com.amparo.amparoapi.mapper.toResponse
import com.amparo.amparoapi.service.AddressService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
final class AddressServiceImpl(private val addressRepository: AddressRepository) : AddressService {
    override fun findAll(): List<AddressResponse> = addressRepository.findAll().map { it.toResponse() }

    override fun findById(id: Long): AddressResponse {
        val address = addressRepository.findById(id)
        if (address.isPresent) {
            return address.get().toResponse()
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(addressRequest: AddressRequest) {
        addressRepository.save(addressRequest.toEntity())
    }

    override fun update(id: Long, addressRequest: AddressRequest) {
        if (addressRepository.findById(id).isPresent) {
            val address = addressRequest.toEntity()
            address.id = id
            addressRepository.save(address)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: Long) {
        if (addressRepository.findById(id).isPresent) {
            addressRepository.deleteById(id)
        } else {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }
    }
}