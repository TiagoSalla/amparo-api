package com.amparo.amparoapi.domain.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "medicine")
data class MedicineEntity(
    @Column(name = "name")
    val name: String,

    @ManyToOne
    @JoinColumn(name = "dosage_id")
    val dosage: DosageEntity,

    @Column(name = "laboratory")
    val laboratory: String,

    @Column(name = "due_date")
    val dueDate: LocalDate,

    @Column(name = "status_active")
    val statusActive: Boolean,

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    var id: Long = 0

    @ManyToMany(mappedBy = "medicineList")
    val treatmentList: List<TreatmentEntity>? = null

    @UpdateTimestamp
    @Column(nullable = false)
    val updatedAt: LocalDateTime? = null
}