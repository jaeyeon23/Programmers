package com.xpanner

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class XpannerConnectPilerApiApplication : CommandLineRunner {
    private val log = LoggerFactory.getLogger(XpannerConnectPilerApiApplication::class.java)

    override fun run(vararg args: String) {
        log.error("error")
        log.warn("warn")
        log.debug("debug")
        log.info("info")
        log.trace("trace")
    }
}

fun main(args: Array<String>) {
    System.setProperty("user.timezone", "UTC")
    runApplication<XpannerConnectPilerApiApplication>(*args)
}
