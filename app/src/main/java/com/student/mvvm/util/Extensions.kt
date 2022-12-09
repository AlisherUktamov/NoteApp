package com.student.mvvm.util

import com.student.mvvm.database.NoteEntity
import com.student.mvvm.model.NoteModel

fun NoteEntity.toNoteModel(): NoteModel = NoteModel(noteText = noteText, noteTitle = noteTitle)

fun NoteModel.toNoteEntity(): NoteEntity = NoteEntity(noteText = noteText, noteTitle = noteTitle)

fun Int.ikkiPlus() = this + 2