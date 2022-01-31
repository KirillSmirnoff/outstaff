package ru.k2.outstaff.persistence.entity

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "workers")
class WorkerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "n_id")
        var id: Long? = null,

        @Column(name = "n_name")
        var name: String? = null,

        @Column(name = "d_birthday")
        var birthday: LocalDate? = null,

        @Column(name = "c_phone")
        var phone: String? = null,

        @Column(name = "c_mail")
        var mail: String? = null,

        @Column(name = "b_status")
        var status: Boolean? = null,

        @Column(name = "n_type")
        var type: String? = null,

        @ManyToOne
        @JoinColumn(name = "n_company_id")
        var companyId: CompanyEntity? = null,
)