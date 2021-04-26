package com.amparo.amparoapi.domain.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "address")
data class AddressEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    val id: Long,

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

    @Column(name = "federative_unit")
    val federativeUnit: String,

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val responsibleList: List<ResponsibleEntity>?,

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val professionalList: List<ProfessionalEntity>?,

    @CreationTimestamp
    @Column
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime
)