package dev.okano.kotlin.magiccardprices.model

import java.math.BigDecimal

data class Price(val amount: BigDecimal, val currency: Currency)
