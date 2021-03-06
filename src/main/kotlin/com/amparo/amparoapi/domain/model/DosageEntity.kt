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

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: LocalDateTime? = null

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dosage_id")
    var id: Long = 0

    @OneToMany(mappedBy = "dosage", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val medicineList: List<MedicineEntity>? = null

    @UpdateTimestamp
    @Column(nullable = false)
    val updatedAt: LocalDateTime? = null
}