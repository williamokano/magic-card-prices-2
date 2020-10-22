package dev.okano.kotlin.magiccardprices.service

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dev.okano.kotlin.magiccardprices.exception.GetCardPriceException
import dev.okano.kotlin.magiccardprices.exception.ProviderGetCardException
import dev.okano.kotlin.magiccardprices.model.Currency
import dev.okano.kotlin.magiccardprices.model.Price
import dev.okano.kotlin.magiccardprices.provider.PriceProvider
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.nio.file.ProviderNotFoundException

internal class PriceServiceTest {

    private val mockPriceProvider: PriceProvider = mock()
    private val mockPriceProviderService: PriceProviderService = mock()
    private val priceService = PriceService(mockPriceProviderService)

    @Test
    fun `should find price for card`() {
        whenever(mockPriceProviderService.findProviderByNameOrThrownException(any()))
            .thenReturn(mockPriceProvider)
        whenever(mockPriceProvider.findByName("Blood Moon"))
            .thenReturn(Price(BigDecimal.TEN, Currency.BRL))

        val price = priceService.getPrice("mock", "Blood Moon")

        assertThat(price).isNotNull()
        assertThat(price.amount).isEqualTo(BigDecimal.TEN)
        assertThat(price.currency).isEqualTo(Currency.BRL)
    }

    @Test
    fun `should throw exception if provider not found`() {
        whenever(mockPriceProviderService.findProviderByNameOrThrownException(any()))
            .thenThrow(ProviderNotFoundException("mock"))

        assertThatThrownBy { priceService.getPrice("mock", "Blood Moon") }
            .isInstanceOf(GetCardPriceException::class.java)
            .hasCauseInstanceOf(ProviderNotFoundException::class.java)
    }

    @Test
    fun `should throw exception if provider cannot find the price`() {
        whenever(mockPriceProviderService.findProviderByNameOrThrownException(any()))
            .thenReturn(mockPriceProvider)
        whenever(mockPriceProvider.findByName("Blood Moon"))
            .thenThrow(ProviderGetCardException("mock", "Blood Moon", RuntimeException("Random Exception")))

        assertThatThrownBy { priceService.getPrice("mock", "Blood Moon") }
            .isInstanceOf(GetCardPriceException::class.java)
            .hasCauseInstanceOf(ProviderGetCardException::class.java)
    }
}
