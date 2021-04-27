package com.amparo.amparoapi.service

import com.amparo.amparoapi.domain.model.AddressEntity

interface AddressService {
    fun findAll(): List<AddressEntity>
    fun findById(id: Long): AddressEntity
    fun create(addressEntity: AddressEntity)
    fun update(id: Long, addressEntity: AddressEntity)
    fun delete(id: Long)
}