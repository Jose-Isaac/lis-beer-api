package com.lisbeer.resource.users

import com.lisbeer.domain.users.UserService
import com.lisbeer.domain.users.UserVO
import com.lisbeer.resource.users.representation.UserRepresentation
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
@RestController
@RequestMapping(
    path = ["/users"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class UserController(
    private val userService: UserService
) {

    @PostMapping("/signup")
    fun signup(@RequestBody user: UserRepresentation): UserVO {
        return userService.create(user.toVO())
    }

    @GetMapping("/me")
    fun me() = ResponseEntity.ok(userService.myself())
}