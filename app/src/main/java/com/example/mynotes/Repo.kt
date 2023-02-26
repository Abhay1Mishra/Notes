package com.example.mynotes

import androidx.lifecycle.LiveData

class Repo(private val notes: Notes) {
    val allData:LiveData<List<Word>> =notes.getAll()

    suspend fun insert(word: Word){
        notes.insert(word)

    }
    suspend fun delete(word: Word){
        notes.delete(word)

    }

}