package com.lisbeer.resource.users

import com.lisbeer.domain.users.UserService
import com.lisbeer.domain.users.toResponseRepresentation
import com.lisbeer.resource.users.representation.UserRepresentation
import org.springframework.http.MediaType
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
    fun signup(@RequestBody user: UserRepresentation) =
         userService
             .create(user.toVO())
             .toResponseRepresentation()

    @GetMapping("/me")
    fun me() =
        userService
            .myself()
            .get()
            .toResponseRepresentation()
}