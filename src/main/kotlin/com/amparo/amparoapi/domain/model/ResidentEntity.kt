package com.amparo.amparoapi.domain.model

import com.amparo.amparoapi.domain.enums.Gender
import com.amparo.amparoapi.domain.enums.MaritalStatus
import com.amparo.amparoapi.domain.enums.Race
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "resident")
data class ResidentEntity(
    @Column(name = "name")
    val name: String,

    @Column(name = "social_name")
    val socialName: String? = null,

    @Column(name = "nickname")
    val nickname: String? = null,

    @Column(name = "cpf")
    val cpf: String,

    @Column(name = "rg")
    val rg: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "race")
    val race: Race,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    val gender: Gender,

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    val maritalStatus: MaritalStatus,

    @Column(name = "birth_date")
    val birthDate: LocalDate,

    @OneToOne
    @JoinColumn(name = "health_insurance_id")
    val healthInsurance: HealthInsuranceEntity,

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: LocalDateTime? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resident_id")
    var id: Long = 0

    @OneToOne(mappedBy = "resident", fetch = FetchType.EAGER, cascade = [CascadeType.REMOVE])
    val responsible: ResponsibleEntity? = null

    @OneToOne(mappedBy = "resident", fetch = FetchType.EAGER, cascade = [CascadeType.REMOVE])
    val treatment: TreatmentEntity? = null

    @UpdateTimestamp
    @Column(nullable = false)
    val updatedAt: LocalDateTime? = null
}