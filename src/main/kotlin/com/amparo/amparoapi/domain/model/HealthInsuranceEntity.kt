package com.amparo.amparoapi.domain.model

import com.amparo.amparoapi.domain.enums.HealthInsuranceType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "health_insurance")
data class HealthInsuranceEntity(
    @Enumerated(EnumType.STRING)
    @Column(name = "health_insurance_type")
    val type: HealthInsuranceType,

    @Column(name = "inscription")
    val inscription: Int,

    @Column(name = "observation")
    val observation: String? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "health_insurance_id")
    var id: Long = 0

    @OneToOne(mappedBy = "healthInsurance", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val resident: ResidentEntity? = null

    @CreationTimestamp
    @Column
    val createdAt: LocalDateTime? = null

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null
}