package com.lisbeer.domain.users

fun UserVO.toEntity(): User {
    return User(
        id = this.id,
        email = this.email,
        password = this.password
    )
}

fun User.toVO(): UserVO {
    return UserVO(
        id = this.id,
        email = this.email,
        password = this.password
    )
}

