package dev.shahbazly.vasoccer.api.response

import dev.shahbazly.vasoccer.model.Match

data class MatchDto(
    var match_id: Long,
    var status_code: Long,
    var match_start: String,
    var match_start_iso: String,
    val group: GroupDto,
    val referee_id: Long?,
    val home_team: TeamDto,
    val away_team: TeamDto,
    val stats: StatsDto,
    val venue: VenueDto,
) {
    fun toModel() = Match(
        matchId = match_id,
        leagueName = group.group_name,
        matchStartDate = match_start,
        homeTeamName = home_team.name,
        homeTeamScore = stats.home_score,
        homeTeamLogo = home_team.logo,
        awayTeamName = away_team.name,
        awayTeamScore = stats.away_score,
        awayTeamLogo = away_team.logo
    )
}