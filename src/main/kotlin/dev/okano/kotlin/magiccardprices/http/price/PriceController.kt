package dev.okano.kotlin.magiccardprices.http.price

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class PriceController(val priceService: PriceService) {

    @GetMapping("/{source}/card/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun cardPrice(@PathVariable("source") source: String, @PathVariable("name") name: String): CardPriceResponse {
        val price = this.priceService.getPrice(name)
        return CardPriceResponse(name, price)
    }
}
