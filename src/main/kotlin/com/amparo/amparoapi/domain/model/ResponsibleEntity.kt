package com.amparo.amparoapi.domain.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "responsible")
data class ResponsibleEntity(
    @Column(name = "name")
    val name: String,

    @Column(name = "social_name")
    val socialName: String? = null,

    @Column(name = "cpf")
    val cpf: String,

    @Column(name = "rg")
    val rg: String,

    @ManyToOne
    @JoinColumn(name = "address_id")
    val address: AddressEntity,

    @Column(name = "email")
    val email: String,

    @Column(name = "mobile_phone")
    val mobilePhone: String,

    @Column(name = "residential_phone")
    val residentialPhone: String? = null,

    @ManyToOne
    @JoinColumn(name = "resident_id")
    val resident: ResidentEntity,

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "responsible_id")
    var id: Long = 0

    @UpdateTimestamp
    @Column(nullable = false)
    val updatedAt: LocalDateTime? = null
}