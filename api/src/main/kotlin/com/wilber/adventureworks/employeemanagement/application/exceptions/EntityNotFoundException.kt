package com.wilber.adventureworks.employeemanagement.application.exceptions

class EntityNotFoundException(message: String) : Exception("Entity not found: $message")
