package com.lisbeer.resource.handles

import com.lisbeer.domain.error.ErrorMessage
import com.lisbeer.domain.error.exeption.ConflictException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun handleConflictException(ex: ConflictException) : ResponseEntity<ErrorMessage> {
        val errorMessage = ErrorMessage(
                ex.message,
                HttpStatus.CONFLICT.value()
            )

        return ResponseEntity(errorMessage, HttpStatus.CONFLICT)
    }
}