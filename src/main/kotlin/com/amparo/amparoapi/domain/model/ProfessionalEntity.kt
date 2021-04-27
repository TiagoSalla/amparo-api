package com.amparo.amparoapi.domain.model

import com.amparo.amparoapi.domain.enums.Gender
import com.amparo.amparoapi.domain.enums.MaritalStatus
import com.amparo.amparoapi.domain.enums.Race
import com.amparo.amparoapi.domain.enums.ProfessionalSpecialty
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "professional")
data class ProfessionalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professional_id")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "social_name")
    val socialName: String? = null,

    @Column(name = "nickname")
    val nickname: String? = null,

    @Column(name = "user")
    val user: String,

    @Column(name = "password")
    val password: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "professional_specialty")
    val professionalSpecialty: ProfessionalSpecialty,

    @Column(name = "register")
    val register: String,

    @Column(name = "cpf")
    val cpf: String,

    @Column(name = "rg")
    val rg: String,

    @Column(name = "birth_date")
    val birthDate: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "race")
    val race: Race,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    val gender: Gender,

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    val maritalStatus: MaritalStatus,

    @ManyToOne
    @JoinColumn(name = "address_id")
    val address: AddressEntity,

    @Column(name = "email")
    val email: String,

    @Column(name = "mobile_phone")
    val mobilePhone: String,

    @Column(name = "residential_phone")
    val residentialPhone: String? = null,

    @OneToMany(mappedBy = "responsibleProfessional", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val treatmentList: List<TreatmentEntity>?,

    @CreationTimestamp
    @Column
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime
)