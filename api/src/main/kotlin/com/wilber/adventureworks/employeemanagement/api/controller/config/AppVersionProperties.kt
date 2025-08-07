package com.wilber.adventureworks.employeemanagement.api.controller.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:version.properties")
@ConfigurationProperties(prefix = "app")
class AppVersionProperties {
    lateinit var version: String
}
