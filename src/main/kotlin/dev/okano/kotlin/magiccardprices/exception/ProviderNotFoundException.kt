package dev.okano.kotlin.magiccardprices.exception

class ProviderNotFoundException(provider: String) : NotFoundException("Could not find provider for slug $provider")
