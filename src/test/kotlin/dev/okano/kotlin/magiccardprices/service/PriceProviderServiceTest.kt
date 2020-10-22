package dev.okano.kotlin.magiccardprices.service

import dev.okano.kotlin.magiccardprices.exception.ProviderNotFoundException
import dev.okano.kotlin.magiccardprices.provider.MockProvider
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class PriceProviderServiceTest {

    private val mockProvider = MockProvider()
    private val priceProviderService = PriceProviderService(listOf(mockProvider))

    @Test
    fun `should return provider if found`() {
        val provider = priceProviderService.findProviderByNameOrThrownException(mockProvider.sourceProviderSlug())
        assertThat(provider).isEqualTo(mockProvider)
    }

    @Test
    fun `should throw exception if provider slug not found`() {
        assertThatThrownBy { priceProviderService.findProviderByNameOrThrownException("idontexist") }
            .isInstanceOf(ProviderNotFoundException::class.java)
    }
}
