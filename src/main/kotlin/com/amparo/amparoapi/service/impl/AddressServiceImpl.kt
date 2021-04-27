package com.amparo.amparoapi.service.impl

import com.amparo.amparoapi.domain.model.AddressEntity
import com.amparo.amparoapi.domain.repository.AddressRepository
import com.amparo.amparoapi.service.AddressService
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl(val addressRepository: AddressRepository) : AddressService {

    override fun findAll(): List<AddressEntity> = addressRepository.findAll()

    override fun findById(id: Long): AddressEntity {
        TODO("Not yet implemented")
    }

    override fun create(addressEntity: AddressEntity) {
        addressRepository.save(addressEntity)
    }

    override fun update(id: Long, addressEntity: AddressEntity) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}