package dev.shahbazly.vasoccer.api.response

data class StatsDto(
    val home_score: Int,
    val away_score: Int,
    val ht_score: String,
    val ft_score: String,
    val et_score: String,
    val ps_score: String,
)
