package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.TreatmentRequest
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

    @ApiOperation(value = "Get treatment selection options")
    @GetMapping(value = ["/options"])
    fun getSelectionOptions() = treatmentService.getSelectionOptions()

    @ApiOperation(value = "Create a treatment")
    @PostMapping(value = ["/create"])
    fun create(@RequestBody treatmentRequest: TreatmentRequest) {
        treatmentService.create(treatmentRequest)
    }

    @ApiOperation(value = "Update a treatment")
    @PutMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody treatmentRequest: TreatmentRequest) {
        treatmentService.update(id, treatmentRequest)
    }

    @ApiOperation(value = "Delete a treatment")
    @DeleteMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        treatmentService.delete(id)
    }
}