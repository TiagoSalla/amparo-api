package com.amparo.amparoapi.domain.model

import com.amparo.amparoapi.domain.enums.FederativeUnit
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "address")
data class AddressEntity(
    @Column(name = "street_name")
    val streetName: String,

    @Column(name = "district")
    val district: String,

    @Column(name = "number")
    val number: Int,

    @Column(name = "complement")
    val observation: String?,

    @Column(name = "zip_code")
    val zipCode: String,

    @Column(name = "city_name")
    val cityName: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "federative_unit")
    val federativeUnit: FederativeUnit,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    var id: Long = 0

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val responsibleList: List<ResponsibleEntity>? = null

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val professionalList: List<ProfessionalEntity>? = null

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: LocalDateTime? = null

    @UpdateTimestamp
    @Column(nullable = false)
    val updatedAt: LocalDateTime? = null
}