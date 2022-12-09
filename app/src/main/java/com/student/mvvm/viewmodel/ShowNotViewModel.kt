package com.student.mvvm.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.student.mvvm.database.NoteDatabase
import com.student.mvvm.database.NoteEntity
import com.student.mvvm.model.NoteModel
import com.student.mvvm.util.toNoteModel

class ShowNotViewModel(application: Application) : AndroidViewModel(application) {
    var database: NoteDatabase? = null

    init {
        database = NoteDatabase.getDatabaseInstance(application.applicationContext)
    }

    fun getNote(id: Int): LiveData<NoteEntity>? {
        return database?.noteDao()?.getNote(id = id)
    }
}