package dev.okano.kotlin.magiccardprices.exception

abstract class BusinessException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)
