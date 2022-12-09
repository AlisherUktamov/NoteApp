package com.student.mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.student.mvvm.database.NoteDatabase
import com.student.mvvm.database.NoteEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepository {
    private var noteDb: NoteDatabase? = null

    fun initDatabase(context: Context) {
        noteDb = NoteDatabase.getDatabaseInstance(context)
    }

    fun insert(note: NoteEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDb?.noteDao()?.insert(note)
        }
    }

    fun getAllNotes(): LiveData<List<NoteEntity>> {
        return noteDb?.noteDao()?.getAllNote()!!
    }
}
