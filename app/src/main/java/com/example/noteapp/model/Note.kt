package com.example.noteapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    val title : String,
    val description : String,
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
)