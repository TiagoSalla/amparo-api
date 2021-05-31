package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.request.AddressRequest
import com.amparo.amparoapi.domain.model.response.AddressResponse

interface AddressService {
    fun findAll(): List<AddressResponse>
    fun findById(id: Long): AddressResponse
    fun create(addressRequest: AddressRequest)
    fun update(id: Long, addressRequest: AddressRequest)
    fun delete(id: Long)
}