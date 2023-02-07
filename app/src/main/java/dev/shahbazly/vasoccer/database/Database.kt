package dev.shahbazly.vasoccer.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.shahbazly.vasoccer.database.dao.MatchDao
import dev.shahbazly.vasoccer.database.entities.MatchEntity

@Database(
    entities = [
        MatchEntity::class
    ], version = 1, exportSchema = false
)
abstract class Database : RoomDatabase() {
    internal abstract fun matchDao(): MatchDao

    companion object {
        const val DATABASE_NAME: String = "va_soccer_data"
    }
}