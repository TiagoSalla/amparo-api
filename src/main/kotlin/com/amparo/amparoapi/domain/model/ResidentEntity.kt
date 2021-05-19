package com.amparo.amparoapi.domain.model

import com.amparo.amparoapi.domain.enums.Gender
import com.amparo.amparoapi.domain.enums.MaritalStatus
import com.amparo.amparoapi.domain.enums.Race
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "resident")
data class ResidentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resident_id")
    var id: Long? = null,

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
    val birthDate: String,

    @ManyToOne
    @JoinColumn(name = "health_insurance_id")
    val healthInsurance: HealthInsuranceEntity,

    @OneToMany(mappedBy = "resident", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val responsibleList: List<ResponsibleEntity>? = null,

    @OneToOne(mappedBy = "resident", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val treatment: TreatmentEntity? = null,

    @CreationTimestamp
    @Column
    val createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null
)