package dev.okano.kotlin.magiccardprices.service

import dev.okano.kotlin.magiccardprices.exception.GetCardPriceException
import dev.okano.kotlin.magiccardprices.model.Price
import org.springframework.stereotype.Service

@Service
class PriceService(private val priceProviderService: PriceProviderService) {
    fun getPrice(providerName: String, cardName: String): Price {
        try {
            return priceProviderService.findProviderByNameOrThrownException(providerName)
                .findByName(cardName)
        } catch (ex: Throwable) {
            throw GetCardPriceException(cardName, ex)
        }
    }
}
