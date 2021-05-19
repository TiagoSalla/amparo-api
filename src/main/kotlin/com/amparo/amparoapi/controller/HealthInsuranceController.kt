package com.amparo.amparoapi.controller

import com.amparo.amparoapi.domain.model.request.create.HealthInsuranceCreateRequest
import com.amparo.amparoapi.domain.model.request.update.HealthInsuranceUpdateRequest
import com.amparo.amparoapi.service.HealthInsuranceService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/health-insurances")
@Api(value = "Health Insurance")
final class HealthInsuranceController(private val healthInsuranceService: HealthInsuranceService) {

    @ApiOperation(value = "Find all health insurances")
    @GetMapping
    fun findAll() = healthInsuranceService.findAll()

    @ApiOperation(value = "Find a health insurance by id")
    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long) = healthInsuranceService.findById(id)

    @ApiOperation(value = "Create a health insurance")
    @PostMapping(value = ["/create"])
    fun create(@RequestBody healthInsuranceCreateRequest: HealthInsuranceCreateRequest) {
        healthInsuranceService.create(healthInsuranceCreateRequest)
    }

    @ApiOperation(value = "Update a health insurance")
    @PostMapping(value = ["/update/{id}"])
    fun update(@PathVariable id: Long, @RequestBody healthInsuranceUpdateRequest: HealthInsuranceUpdateRequest) {
        healthInsuranceService.update(id, healthInsuranceUpdateRequest)
    }

    @ApiOperation(value = "Delete a health insurance")
    @GetMapping(value = ["/delete/{id}"])
    fun delete(@PathVariable id: Long) {
        return healthInsuranceService.delete(id)
    }
}