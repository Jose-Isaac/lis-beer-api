package com.lisbeer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LisBeerApplication

fun main(args: Array<String>) {
    runApplication<LisBeerApplication>(*args)
}
