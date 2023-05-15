package com.lisbeer.domain.users

import com.lisbeer.resource.users.representation.UserResponseRepresentation

fun UserVO.toEntity(): User {
    return User(
        id = this.id,
        email = this.email,
        password = this.password,
        username = this.username,
    )
}

fun UserVO.toEntity(encodedPassword: String): User {
    return User(
        id = this.id,
        email = this.email,
        password = encodedPassword,
        username = this.username,
    )
}

fun User.toVO(): UserVO {
    return UserVO(
        id = this.id,
        email = this.email,
        password = this.password,
        username = this.username,
    )
}

fun UserVO.toResponseRepresentation() = UserResponseRepresentation(
    id = this.id,
    email = this.email,
    username = this.username,
)
