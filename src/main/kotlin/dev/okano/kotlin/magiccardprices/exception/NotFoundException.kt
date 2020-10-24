package dev.okano.kotlin.magiccardprices.exception

import java.lang.RuntimeException

abstract class NotFoundException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)
