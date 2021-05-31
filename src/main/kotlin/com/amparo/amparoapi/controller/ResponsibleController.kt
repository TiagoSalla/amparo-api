package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.ResponsibleRequest
import com.amparo.amparoapi.service.ResponsibleService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/responsibles")
@Api(value = "Responsible")
final class ResponsibleController(private val responsibleService: ResponsibleService) {

    @ApiOperation(value = "Find all responsibles")
    @GetMapping
    fun findAll() = responsibleService.findAll()

    @ApiOperation(value = "Find a responsible by id")
    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long) = responsibleService.findById(id)

    @ApiOperation(value = "Create a responsible")
    @PostMapping(value = ["/create"])
    fun create(@RequestBody responsibleRequest: ResponsibleRequest) {
        responsibleService.create(responsibleRequest)
    }

    @ApiOperation(value = "Update a responsible")
    @PostMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody responsibleRequest: ResponsibleRequest) {
        responsibleService.update(id, responsibleRequest)
    }

    @ApiOperation(value = "Delete a responsible")
    @GetMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        responsibleService.delete(id)
    }
}