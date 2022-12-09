package com.student.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.student.mvvm.model.NoteModel
import com.student.mvvm.repository.NoteRepository
import com.student.mvvm.util.toNoteEntity

class AddNoteViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: NoteRepository = NoteRepository()

    init {
        repository.initDatabase(application.applicationContext)
    }

    fun insert(noteEntity: NoteModel) {
        repository.insert(noteEntity.toNoteEntity())
    }
}