package com.amparo.amparoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AmparoApiApplication

fun main(args: Array<String>) {
    runApplication<AmparoApiApplication>(*args)
}
