package dev.shahbazly.vasoccer.api.response

data class CountryDto(
    val country_id: Long,
    val name: String,
    val country_code: String,
    val continent: String,
)
