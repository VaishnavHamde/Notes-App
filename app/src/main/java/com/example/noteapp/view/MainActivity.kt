package com.example.noteapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.NoteApplication
import com.example.noteapp.R
import com.example.noteapp.adapters.NoteAdapter
import com.example.noteapp.viewmodel.NoteViewModel
import com.example.noteapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel : NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val noteAdapter = NoteAdapter()
        recyclerView.adapter = noteAdapter

        val viewModelFactory = NoteViewModelFactory((application as NoteApplication).repository)

        noteViewModel = ViewModelProvider(this, viewModelFactory).get(NoteViewModel::class.java)

        noteViewModel.myALlNotes.observe(this, Observer { notes ->
            // Update UI
            noteAdapter.setNote(notes)
        })
    }
}