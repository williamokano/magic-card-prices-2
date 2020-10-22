package dev.okano.kotlin.magiccardprices.http.price

import org.springframework.stereotype.Service

@Service
class PriceService {

    fun getPrice(name: String): Int {
        return 10;
    }

}