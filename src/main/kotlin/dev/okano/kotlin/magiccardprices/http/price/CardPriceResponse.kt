package dev.okano.kotlin.magiccardprices.http.price

import dev.okano.kotlin.magiccardprices.model.Card
import dev.okano.kotlin.magiccardprices.model.Price

data class CardPriceResponse(
    val card: Card,
    val price: Price
)
