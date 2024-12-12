package com.xpanner.domain

import com.xpanner.global.common.response.SingleResult
import com.xpanner.global.common.response.service.ResponseService
import com.xpanner.hardware.HardwareUUIDProvider
import org.slf4j.LoggerFactory
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/public")
class PublicController(
    val responseService: ResponseService,
) {
    private val log = LoggerFactory.getLogger(PublicController::class.java)

    @GetMapping
    fun getMessage(): String {
        return "Hello from public API controller"
    }

    @GetMapping("/utc-time")
    fun getUtcTime(
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        value: LocalDateTime,
    ): SingleResult<String> {
        val now = LocalDateTime.now()
        log.info("""client now : $value""")
        log.info("""server now : $now""")
        return responseService.getSingleResult(now.toString())
    }

    @GetMapping("/mac")
    fun getMac(): SingleResult<String> {
        val result = HardwareUUIDProvider.getHardwareUUID()
        return responseService.getSingleResult(result)
    }
}
