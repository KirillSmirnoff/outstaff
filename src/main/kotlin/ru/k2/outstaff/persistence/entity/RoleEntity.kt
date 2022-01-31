package ru.k2.outstaff.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "roles")
class RoleEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    var id: Long? = null,

    @Column(name = "C_role_name")
    var roleName: String? = null,

    @Column(name = "c_comment")
    var comment: String? = null,

    @OneToMany(mappedBy = "role")
    var userRoles: MutableList<UserRoleEntity>? = null
)