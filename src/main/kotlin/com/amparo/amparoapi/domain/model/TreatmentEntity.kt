package com.amparo.amparoapi.domain.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "treatment")
data class TreatmentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    var id: Long? = null,

    @OneToOne
    @JoinColumn(name = "resident_id")
    val resident: ResidentEntity,

    @ManyToOne
    @JoinColumn(name = "professional_id")
    val responsibleProfessional: ProfessionalEntity,

    @ManyToMany
    @JoinTable(
        name = "medicine_treatment",
        joinColumns = [JoinColumn(name = "treatment_id")],
        inverseJoinColumns = [JoinColumn(name = "medicine_id")]
    )
    val medicineList: List<MedicineEntity>,

    @CreationTimestamp
    @Column
    val createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null
)