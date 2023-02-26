package com.example.mynotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Notes{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Delete
    suspend fun delete(word: Word)

    @Query("SELECT * from Word_table order by id ASC")
    fun getAll():LiveData<List<Word>>
}