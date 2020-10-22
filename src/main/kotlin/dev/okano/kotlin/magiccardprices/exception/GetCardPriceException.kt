package dev.okano.kotlin.magiccardprices.exception

class GetCardPriceException(cardName: String, cause: Throwable?) :
    RuntimeException("Failed to get card $cardName", cause)
