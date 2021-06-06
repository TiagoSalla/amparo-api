package com.amparo.amparoapi.domain.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "treatment")
data class TreatmentEntity(
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
    @Column(nullable = false)
    val createdAt: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    var id: Long = 0

    @UpdateTimestamp
    @Column(nullable = false)
    val updatedAt: LocalDateTime? = null
}