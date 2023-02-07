package dev.shahbazly.vasoccer.api

import dev.shahbazly.vasoccer.api.response.MatchDto
import dev.shahbazly.vasoccer.api.response.MatchesResponseDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchApi {

    @GET("/soccer/matches")
    fun getMatches(
        @Query("season_id") seasonId: Long
    ): Single<MatchesResponseDto>
}