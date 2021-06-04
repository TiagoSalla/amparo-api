package com.amparo.amparoapi.domain.model.request

data class LoginRequest(
    val username: String,
    val password: String
)