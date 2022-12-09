package com.student.mvvm.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(noteEntity: NoteEntity)

    @Query("SELECT * FROM NOTE_LIST ORDER BY id DESC")
    fun getAllNote(): LiveData<List<NoteEntity>>

    @Query("SELECT * FROM note_list WHERE ID = :id")
    fun getNote(id: Int): LiveData<NoteEntity>
}