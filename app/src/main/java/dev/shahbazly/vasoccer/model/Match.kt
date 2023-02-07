package dev.shahbazly.vasoccer.model

import java.io.Serializable

class Match(
    var matchId: Long,
    var leagueName: String,
    var matchStartDate: String,

    var homeTeamName: String,
    var homeTeamLogo: String,
    var homeTeamScore: Int,

    var awayTeamName: String,
    var awayTeamLogo: String,
    var awayTeamScore: Int,
) : Serializable