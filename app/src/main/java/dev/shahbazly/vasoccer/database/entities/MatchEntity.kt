package dev.shahbazly.vasoccer.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.shahbazly.vasoccer.model.Match

@Entity(tableName = "matches")
class MatchEntity() {

    @PrimaryKey(autoGenerate = false)
    var match_id: Long = 0
    var league_name: String = ""
    var match_start: String = ""

    var home_team_name: String = ""
    var home_team_logo: String = ""
    var home_team_score: Int = 0

    var away_team_name: String = ""
    var away_team_logo: String = ""
    var away_team_score: Int = 0

    constructor(match: Match) : this() {
        match_id = match.matchId
        league_name = match.leagueName
        match_start = match.matchStartDate
        home_team_name = match.homeTeamName
        home_team_logo = match.homeTeamLogo
        home_team_score = match.homeTeamScore
        away_team_name = match.awayTeamName
        away_team_logo = match.awayTeamLogo
        away_team_score = match.awayTeamScore
    }
}