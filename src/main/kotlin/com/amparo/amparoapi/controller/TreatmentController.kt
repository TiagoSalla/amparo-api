package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.create.TreatmentCreateRequest
import com.amparo.amparoapi.domain.model.request.update.TreatmentUpdateRequest
import com.amparo.amparoapi.service.TreatmentService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/treatments")
@Api(value = "Treatment")
final class TreatmentController(private val treatmentService: TreatmentService) {

    @ApiOperation(value = "Find all treatments")
    @GetMapping
    fun findAll() = treatmentService.findAll()

    @ApiOperation(value = "Find a treatment by id")
    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long) = treatmentService.findById(id)

    @ApiOperation(value = "Create a treatment")
    @PostMapping(value = ["/create"])
    fun create(@RequestBody treatmentCreateRequest: TreatmentCreateRequest) {
        treatmentService.create(treatmentCreateRequest)
    }

    @ApiOperation(value = "Update a treatment")
    @PostMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody treatmentUpdateRequest: TreatmentUpdateRequest) {
        treatmentService.update(id, treatmentUpdateRequest)
    }

    @ApiOperation(value = "Delete a treatment")
    @GetMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        treatmentService.delete(id)
    }
}