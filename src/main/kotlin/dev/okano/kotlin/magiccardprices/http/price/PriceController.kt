package dev.okano.kotlin.magiccardprices.http.price

import dev.okano.kotlin.magiccardprices.model.Card
import dev.okano.kotlin.magiccardprices.service.PriceService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class PriceController(private val priceService: PriceService) {

    @GetMapping("/{source}/card/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun cardPrice(@PathVariable("source") source: String, @PathVariable("name") name: String): CardPriceResponse {
        val price = priceService.getPrice(source, name)
        return CardPriceResponse(Card(name), price)
    }
}
