package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.create.AddressCreateRequest
import com.amparo.amparoapi.domain.model.request.update.AddressUpdateRequest
import com.amparo.amparoapi.domain.model.response.AddressResponse

interface AddressService {
    fun findAll(): List<AddressResponse>
    fun findById(id: Long): AddressResponse
    fun create(addressRequest: AddressCreateRequest)
    fun update(id: Long, addressRequest: AddressUpdateRequest)
    fun delete(id: Long)
}