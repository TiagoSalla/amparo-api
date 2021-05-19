package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.create.AddressCreateRequest
import com.amparo.amparoapi.domain.model.request.update.AddressUpdateRequest
import com.amparo.amparoapi.service.AddressService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/addresses")
@Api(value = "Address")
final class AddressController(private val addressService: AddressService) {

    @ApiOperation(value = "Find all addresses")
    @GetMapping
    fun findAll() = addressService.findAll()

    @ApiOperation(value = "Find an address by id")
    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long) = addressService.findById(id)

    @ApiOperation(value = "Create an address")
    @PostMapping(value = ["/create"])
    fun create(@RequestBody addressCreateRequest: AddressCreateRequest) {
        addressService.create(addressCreateRequest)
    }

    @ApiOperation(value = "Update an address")
    @PostMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody addressUpdateRequest: AddressUpdateRequest) {
        addressService.update(id, addressUpdateRequest)
    }

    @ApiOperation(value = "Delete an address")
    @GetMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        return addressService.delete(id)
    }
}