package com.amparo.amparoapi.domain.enums

enum class QuantityType(val description: String) {
    PILL("Comprimido(s)"),
    CAPSULE("Cápsula(s)"),
    DROPS("Gota(s)"),
    ML("Ml"),
    MG("Mg"),
    G("g")
}