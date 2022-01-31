package ru.k2.outstaff.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "companies")
class CompanyEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "n_id")
        var id: Int? = null,

        @Column(name = "c_company_name")
        var companyName: String? = null,

        @Column(name = "c_additonal")
        var additional: String? = null
)

