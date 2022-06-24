package com.lisbeer.resource.users

import com.lisbeer.domain.users.UserService
import com.lisbeer.domain.users.UserVO
import com.lisbeer.resource.users.representation.UserRepresentation
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
    fun create(@RequestBody user: UserRepresentation): UserVO {
        return userService.create(user.toVO())
    }
}