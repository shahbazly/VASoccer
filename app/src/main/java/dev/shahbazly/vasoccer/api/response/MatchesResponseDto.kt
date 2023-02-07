package dev.shahbazly.vasoccer.api.response

data class MatchesResponseDto(
    var query: QueryDto,
    val data: List<MatchDto>
)