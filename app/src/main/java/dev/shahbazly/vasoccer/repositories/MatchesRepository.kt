package dev.shahbazly.vasoccer.repositories

import android.content.Context
import dev.shahbazly.vasoccer.api.MatchApi
import dev.shahbazly.vasoccer.database.DatabaseCreator
import dev.shahbazly.vasoccer.database.entities.MatchEntity
import dev.shahbazly.vasoccer.model.Match
import io.reactivex.Single

class MatchesRepository(
    private val context: Context,
    private val matchApi: MatchApi
) {
    private val matchDto = DatabaseCreator.getInstance(context).database.matchDao()

    fun fetchMatches(seasonId: Long): Single<List<Match>> = matchApi.getMatches(seasonId).map { it.data.map { it.toModel() } }

    fun saveMatches(matches: List<Match>) = matchDto.insertRx(
        matches.map { item ->
            MatchEntity(item)
        }
    )
}