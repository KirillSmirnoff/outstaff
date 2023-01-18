package ru.k2.outstaff.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.k2.outstaff.persistence.dto.roles.RoleCreateRequest
import ru.k2.outstaff.persistence.dto.roles.RoleDto
import ru.k2.outstaff.persistence.dto.users.UserRoleDto
import ru.k2.outstaff.persistence.dto.users.UserCreateRequest
import ru.k2.outstaff.service.RoleService
import ru.k2.outstaff.service.UserRoleService
import ru.k2.outstaff.service.UserService

@RestController
@RequestMapping("/admin")
class AdminController(private val roleService: RoleService,
                      private val userService: UserService,
                      private val userRoleService: UserRoleService) {

    @GetMapping("/roles")
    fun getRoles(@RequestParam(defaultValue = "false") isDeleted: Boolean): ResponseEntity<List<RoleDto>>{
        val roles = roleService.findRoles(isDeleted)
        return ResponseEntity.ok(roles)
    }

    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<UserRoleDto>> {
        val all = userService.getAllUsersWithRoles()
        return ResponseEntity.ok(all)
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    fun userRegister(@RequestBody roleDto: UserCreateRequest) {
        userRoleService.saveUser(roleDto)
    }

    @PostMapping("/role")
    @ResponseStatus(HttpStatus.CREATED)
    fun roleRegister(@RequestBody newRole: RoleCreateRequest){
        roleService.saveRole(newRole)
    }

    @DeleteMapping("/role/{roleId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun removeRole(@PathVariable("roleId") roleId: String){
        roleService.remove(roleId)
    }
}