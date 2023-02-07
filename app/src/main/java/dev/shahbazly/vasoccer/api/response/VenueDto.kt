package dev.shahbazly.vasoccer.api.response

data class VenueDto(
    val venue_id: Long,
    val name: String,
    val capacity: Int,
    val city: String,
    val country_id: Long,
)
