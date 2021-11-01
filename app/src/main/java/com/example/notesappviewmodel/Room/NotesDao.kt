package com.example.notesapproom.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {
    @Query("SELECT * FROM Notes")
    fun getAllNotesInfo(): LiveData<List<Notes>>

    @Insert
    fun insertNote(note: Notes)

    @Update
    fun updateNote(note: Notes)

    @Delete
    fun deleteNote(note: Notes)
}