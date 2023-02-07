package dev.shahbazly.vasoccer.database.dao

import androidx.room.Dao
import androidx.room.Query
import dev.shahbazly.vasoccer.database.entities.MatchEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MatchDao : BaseDao<MatchEntity> {

    @Query("Delete from matches")
    fun clearTable(): Completable

    @Query("SELECT * FROM matches")
    fun all(): Single<List<MatchEntity>>
}