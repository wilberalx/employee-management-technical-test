package com.wilber.adventureworks.employeemanagement.api.exceptions

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

@ControllerAdvice
class ExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException::class)
    fun entityNotFoundExceptionHandler(ex: EntityNotFoundException): ResponseEntity<Map<String, String>> {
        val respuesta = mutableMapOf<String, String>()

        respuesta["title"] = "Entity not found"
        respuesta["message"] = ex.message ?: "The requested entity was not found"

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(respuesta)
    }

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException::class)
    fun dataIntegrityViolationHandler(ex: DataIntegrityViolationException): ResponseEntity<Map<String, String>> {
        val respuesta = mutableMapOf<String, String>()

        respuesta["title"] = "Data integrity violation"
        respuesta["message"] = ex.mostSpecificCause.message ?: ex.message ?: "Unknown integrity constraint violation"

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(respuesta)
    }

    @ResponseBody
    @ExceptionHandler(Exception::class)
    fun genericExceptionHandler(ex: Exception): ResponseEntity<Map<String, String>> {
        val respuesta = mutableMapOf<String, String>()

        respuesta["title"] = "Unexpected error"
        respuesta["message"] = ex.message ?: "An unexpected error occurred"

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(respuesta)
    }

}
