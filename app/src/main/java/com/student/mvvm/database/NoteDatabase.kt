package com.student.mvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        var instance: NoteDatabase? = null

        fun getDatabaseInstance(context: Context): NoteDatabase {
            if (instance == null) {
                synchronized(NoteDatabase::class.java) {
                    instance =
                        Room.databaseBuilder(
                            context, NoteDatabase::class.java,
                            "note_database"
                        ).build()
                }
            }
            return instance!!
        }


    }

}