package com.amparo.amparoapi.domain.model

import com.amparo.amparoapi.domain.enums.Gender
import com.amparo.amparoapi.domain.enums.MaritalStatus
import com.amparo.amparoapi.domain.enums.Race
import com.amparo.amparoapi.domain.enums.ProfessionalSpecialty
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity(name = "medicine")
data class MedicineEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @ManyToMany
    @JoinTable(
        name = "medicine_dosage",
        joinColumns = [JoinColumn(name = "medicine_id")],
        inverseJoinColumns = [JoinColumn(name = "dosage_id")]
    )
    val dosageList: List<DosageEntity>,

    @Column(name = "laboratory")
    val laboratory: String,

    @Column(name = "due_date")
    val dueDate: Date,

    @Column(name = "status_active")
    val statusActive: Boolean,

    @ManyToMany(mappedBy = "medicineList")
    val treatmentList: List<TreatmentEntity>?,

    @CreationTimestamp
    @Column
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime
)