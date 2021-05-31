package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.MedicineRequest
import com.amparo.amparoapi.service.MedicineService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/medicines")
@Api(value = "Medicine")
final class MedicineController(private val medicineService: MedicineService) {

    @ApiOperation(value = "Find all medicines")
    @GetMapping
    fun findAll() = medicineService.findAll()

    @ApiOperation(value = "Find a medicine by id")
    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long) = medicineService.findById(id)

    @ApiOperation(value = "Create a medicine")
    @PostMapping(value = ["/create"])
    fun create(@RequestBody medicineRequest: MedicineRequest) {
        medicineService.create(medicineRequest)
    }

    @ApiOperation(value = "Update a medicine")
    @PostMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody medicineRequest: MedicineRequest) {
        medicineService.update(id, medicineRequest)
    }

    @ApiOperation(value = "Delete a medicine")
    @GetMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        medicineService.delete(id)
    }
}