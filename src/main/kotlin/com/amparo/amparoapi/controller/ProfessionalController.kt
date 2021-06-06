package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.LoginRequest
import com.amparo.amparoapi.domain.model.request.ProfessionalRequest
import com.amparo.amparoapi.service.ProfessionalService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun create(@RequestBody professionalRequest: ProfessionalRequest) {
        professionalService.create(professionalRequest)
    }

    @ApiOperation(value = "Update a professional")
    @DeleteMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody professionalRequest: ProfessionalRequest) {
        professionalService.update(id, professionalRequest)
    }

    @ApiOperation(value = "Delete a professional")
    @PutMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        professionalService.delete(id)
    }

    @ApiOperation(value = "Validate professional login info")
    @PostMapping(value = ["/login"])
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun login(@RequestBody loginRequest: LoginRequest) {
        professionalService.login(loginRequest)
    }
}