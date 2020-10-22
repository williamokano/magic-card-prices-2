package dev.okano.kotlin.magiccardprices.service

import dev.okano.kotlin.magiccardprices.exception.ProviderNotFoundException
import dev.okano.kotlin.magiccardprices.provider.PriceProvider
import org.springframework.stereotype.Service

@Service
class PriceProviderService(private val providers: List<PriceProvider>) {
    fun findProviderByNameOrThrownException(providerName: String): PriceProvider {
        return providers.firstOrNull { it.sourceProviderSlug() == providerName }
            ?: throw ProviderNotFoundException(providerName)
    }
}
