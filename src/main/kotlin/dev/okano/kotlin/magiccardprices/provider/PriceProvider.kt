package dev.okano.kotlin.magiccardprices.provider

import dev.okano.kotlin.magiccardprices.model.Price

interface PriceProvider {
    fun findByName(cardName: String): Price
    fun sourceProviderSlug(): String
}
