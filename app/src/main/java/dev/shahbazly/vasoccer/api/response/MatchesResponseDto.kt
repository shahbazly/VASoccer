package dev.shahbazly.vasoccer.api.response

data class MatchesResponseDto(
    var query: List<String>,
    val data: List<MatchDto>
)