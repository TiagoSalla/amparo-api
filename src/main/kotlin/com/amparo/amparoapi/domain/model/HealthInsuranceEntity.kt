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
    var id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "inscription")
    val inscription: Int,

    @Column(name = "observation")
    val observation: String? = null,

    @OneToMany(mappedBy = "healthInsurance", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val residentList: List<ResidentEntity>? = null,

    @CreationTimestamp
    @Column
    val createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null
)