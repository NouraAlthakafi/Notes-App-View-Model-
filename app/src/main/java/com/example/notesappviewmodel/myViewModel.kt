package com.example.notesappviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notesapproom.Room.Notes
import com.example.notesapproom.Room.NotesDatabase
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class myViewModel(activity: Application): AndroidViewModel(activity){
    private lateinit var notesArray: LiveData<List<Notes>>
    val db = NotesDatabase.getInstance(activity).NotesDao()

    init{
        notesArray = db.getAllNotesInfo()
    }
    fun getNotesList(): LiveData<List<Notes>> {
        return notesArray
    }
    fun insertNote(note: Notes){
        GlobalScope.launch(Main) {
            db.insertNote(note)
        }
    }
    fun updateNote(note: Notes){
        GlobalScope.launch(Main) {
            db.updateNote(note)
        }
    }
    fun deleteNote(note: Notes){
        GlobalScope.launch(Main) {
            db.deleteNote(note)
        }
    }
}