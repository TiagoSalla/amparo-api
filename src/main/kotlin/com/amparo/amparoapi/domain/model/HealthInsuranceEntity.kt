package com.amparo.amparoapi.domain.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "health_insurance")
data class HealthInsuranceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "health_insurance_id")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "inscription")
    val inscription: Int,

    @Column(name = "observation")
    val observation: String?,

    @OneToMany(mappedBy = "healthInsurance", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val residentList: List<ResidentEntity>?,

    @CreationTimestamp
    @Column
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime
)