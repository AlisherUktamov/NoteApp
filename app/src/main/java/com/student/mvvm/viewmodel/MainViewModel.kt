package com.student.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.student.mvvm.database.NoteEntity
import com.student.mvvm.repository.NoteRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: NoteRepository = NoteRepository()


    init {
        repository.initDatabase(application.applicationContext)
    }

    fun getAllNotes(): LiveData<List<NoteEntity>> {
        return repository.getAllNotes()
    }
}

