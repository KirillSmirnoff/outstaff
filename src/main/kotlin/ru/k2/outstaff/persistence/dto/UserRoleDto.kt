package ru.k2.outstaff.persistence.dto

data class UserRoleDto(
        var userName: String? = null,
        var login: String? = null,
        var password: String? = null,
        var phone: String? = null,
        var mail: String? = null,
        var roles: List<String>? = null
)