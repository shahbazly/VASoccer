package dev.shahbazly.vasoccer.database

import android.content.Context
import androidx.room.Room

class DatabaseCreator private constructor(context: Context) {

    /**
     * Used to observe when the database initialization is done
     */

    val database: Database by lazy {
        val builder = Room.databaseBuilder(
            context.applicationContext,
            Database::class.java,
            Database.DATABASE_NAME
        )
        builder.build()
    }

    companion object {
        private var sInstance: DatabaseCreator? = null

        fun getInstance(context: Context): DatabaseCreator {
            synchronized(DatabaseCreator::class.java) {
                return sInstance ?: DatabaseCreator(context).apply { sInstance = this }
            }
        }
    }
}