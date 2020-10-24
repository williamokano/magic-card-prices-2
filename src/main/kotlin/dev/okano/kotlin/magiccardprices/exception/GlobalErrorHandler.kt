package dev.okano.kotlin.magiccardprices.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [NotFoundException::class])
    @ResponseBody
    fun handleNotFoundException(ex: NotFoundException): Map<String, String> =
        mapOf("message" to ex.message!!)

    @ExceptionHandler(value = [BusinessException::class])
    fun handleBusinessException(ex: BusinessException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(mapOf("message" to ex.message))
    }

    @ExceptionHandler(value = [Throwable::class])
    fun handleThrowable(ex: Throwable): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Internal server error")
    }
}
