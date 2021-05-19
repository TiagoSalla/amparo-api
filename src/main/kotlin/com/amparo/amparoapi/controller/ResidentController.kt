package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.create.ResidentCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ResidentUpdateRequest
import com.amparo.amparoapi.service.ResidentService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/residents")
@Api(value = "Resident")
final class ResidentController(private val residentService: ResidentService) {

    @ApiOperation(value = "Find all residents")
    @GetMapping
    fun findAll() = residentService.findAll()

    @ApiOperation(value = "Find a resident by id")
    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long) = residentService.findById(id)

    @ApiOperation(value = "Create a resident")
    @PostMapping(value = ["/create"])
    fun create(@RequestBody residentCreateRequest: ResidentCreateRequest) {
        residentService.create(residentCreateRequest)
    }

    @ApiOperation(value = "Update a resident")
    @PostMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody residentUpdateRequest: ResidentUpdateRequest) {
        residentService.update(id, residentUpdateRequest)
    }

    @ApiOperation(value = "Delete a resident")
    @GetMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        residentService.delete(id)
    }
}