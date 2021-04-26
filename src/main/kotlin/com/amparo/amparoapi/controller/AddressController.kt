package com.amparo.amparoapi.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/addresses")
@Api(value = "Address")
class AddressController {

    @ApiOperation(value = "Test")
    @GetMapping(value = ["/{name}"])
    fun hello(@PathVariable name: String): String {
        return "Hello $name"
    }
}