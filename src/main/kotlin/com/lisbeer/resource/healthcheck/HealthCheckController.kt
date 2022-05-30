package com.lisbeer.resource.healthcheck

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(
    path = ["/healthcheck"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
@Validated
class HealthCheckController{

    @GetMapping
    fun healthcheck(): String {
        return "Ok"
    }
}
