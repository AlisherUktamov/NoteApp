package com.student.mvvm.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_list")
data class NoteEntity(val noteTitle: String, val noteText: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}