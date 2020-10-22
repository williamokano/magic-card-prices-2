package dev.okano.kotlin.magiccardprices.provider

import dev.okano.kotlin.magiccardprices.exception.ProviderGetCardException
import dev.okano.kotlin.magiccardprices.model.Currency
import dev.okano.kotlin.magiccardprices.model.Price
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.math.BigDecimal

@Service
class MockProvider : PriceProvider {
    override fun findByName(cardName: String): Price {
        if (cardName == "Blood Moon") {
            return Price(BigDecimal.TEN, Currency.BRL)
        }
        throw ProviderGetCardException(sourceProviderSlug(), cardName, RuntimeException("Forced mock exception"))
    }

    override fun sourceProviderSlug(): String = "mock"
}
