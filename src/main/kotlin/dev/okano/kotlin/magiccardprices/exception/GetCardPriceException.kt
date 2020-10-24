package dev.okano.kotlin.magiccardprices.exception

class GetCardPriceException(cardName: String, cause: Throwable?) :
    BusinessException("Failed to get card $cardName", cause)
