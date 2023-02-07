package dev.shahbazly.vasoccer.api.response

data class TeamDto(
    val team_id: Long,
    val name: String,
    val short_code: String,
    val common_name: String,
    val logo: String,
    val country: CountryDto
)
