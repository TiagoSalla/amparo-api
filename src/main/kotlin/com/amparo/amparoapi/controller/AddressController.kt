package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.AddressRequest
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
    fun create(@RequestBody addressRequest: AddressRequest) {
        addressService.create(addressRequest)
    }

    @ApiOperation(value = "Update an address")
    @PutMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody addressRequest: AddressRequest) {
        addressService.update(id, addressRequest)
    }

    @ApiOperation(value = "Delete an address")
    @DeleteMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        return addressService.delete(id)
    }
}