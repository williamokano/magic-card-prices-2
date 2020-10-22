package dev.okano.kotlin.magiccardprices.exception

class ProviderGetCardException(provider: String, cardName: String, cause: Throwable?) :
    RuntimeException("Failed to get card $cardName from $provider", cause)
