package dev.shahbazly.vasoccer.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Completable

interface BaseDao<T> {
    @Insert
    fun insert(data: Array<T>): LongArray

    @Insert
    fun insert(data: List<T>): LongArray

    @Insert
    fun insert(data: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRx(data: T): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRx(data: List<T>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateRx(data: List<T>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateRx(data: T): Completable

    @Delete
    fun delete(data: Array<T>)

    @Delete
    fun delete(data: List<T>)

    @Delete
    fun delete(data: T)
}
