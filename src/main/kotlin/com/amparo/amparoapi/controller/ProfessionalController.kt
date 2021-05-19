package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.create.ProfessionalCreateRequest
import com.amparo.amparoapi.domain.model.request.update.ProfessionalUpdateRequest
import com.amparo.amparoapi.service.ProfessionalService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/professionals")
@Api(value = "Professional")
final class ProfessionalController(private val professionalService: ProfessionalService) {

    @ApiOperation(value = "Find all professionals")
    @GetMapping
    fun findAll() = professionalService.findAll()

    @ApiOperation(value = "Find a professional by id")
    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long) = professionalService.findById(id)

    @ApiOperation(value = "Create a professional")
    @PostMapping(value = ["/create"])
    fun create(@RequestBody professionalCreateRequest: ProfessionalCreateRequest) {
        professionalService.create(professionalCreateRequest)
    }

    @ApiOperation(value = "Update a professional")
    @PostMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody professionalUpdateRequest: ProfessionalUpdateRequest) {
        professionalService.update(id, professionalUpdateRequest)
    }

    @ApiOperation(value = "Delete a professional")
    @GetMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        professionalService.delete(id)
    }
}