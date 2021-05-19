package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.create.DosageCreateRequest
import com.amparo.amparoapi.domain.model.request.update.DosageUpdateRequest
import com.amparo.amparoapi.service.DosageService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dosages")
@Api(value = "Dosage")
final class DosageController(private val dosageService: DosageService) {

    @ApiOperation(value = "Find all dosages")
    @GetMapping
    fun findAll() = dosageService.findAll()

    @ApiOperation(value = "Find a dosage by id")
    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long) = dosageService.findById(id)

    @ApiOperation(value = "Create a dosage")
    @PostMapping(value = ["/create"])
    fun create(@RequestBody dosageCreateRequest: DosageCreateRequest) {
        dosageService.create(dosageCreateRequest)
    }

    @ApiOperation(value = "Update a dosage")
    @PostMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody dosageUpdateRequest: DosageUpdateRequest) {
        dosageService.update(id, dosageUpdateRequest)
    }

    @ApiOperation(value = "Delete a dosage")
    @GetMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        return dosageService.delete(id)
    }
}