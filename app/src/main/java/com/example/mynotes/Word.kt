package com.example.mynotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Word_table")
data class Word(@ColumnInfo("text")var text: String){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}