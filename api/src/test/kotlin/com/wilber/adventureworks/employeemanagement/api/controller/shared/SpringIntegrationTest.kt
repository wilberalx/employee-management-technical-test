package com.wilber.adventureworks.employeemanagement.api.controller.shared

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Rollback
open class SpringIntegrationTest {

    @Autowired
    protected lateinit var mockMvc: MockMvc
}
