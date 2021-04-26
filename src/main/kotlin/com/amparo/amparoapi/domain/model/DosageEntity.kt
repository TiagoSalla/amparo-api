package com.amparo.amparoapi.domain.model

import com.amparo.amparoapi.domain.enums.AdministrationRoute
import com.amparo.amparoapi.domain.enums.FrequencyType
import com.amparo.amparoapi.domain.enums.QuantityType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "dosage")
data class DosageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dosage_id")
    val id: Long,

    @Column(name = "quantity")
    val quantity: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "quantity_type")
    val quantityType: QuantityType,

    @Column(name = "frequency")
    val frequency: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "frequency_type")
    val frequencyType: FrequencyType,

    @Enumerated(EnumType.STRING)
    @Column(name = "administration_route")
    val administrationRoute: AdministrationRoute,

    @ManyToMany(mappedBy = "dosageList")
    val medicineList: List<MedicineEntity>?,

    @CreationTimestamp
    @Column
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime
)