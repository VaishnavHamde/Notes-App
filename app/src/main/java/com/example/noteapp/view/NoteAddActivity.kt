package com.example.noteapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.noteapp.R

class NoteAddActivity : AppCompatActivity() {

    lateinit var noteTitle : EditText
    lateinit var noteDescription : EditText
    lateinit var save : Button
    lateinit var cancel : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)

        supportActionBar?.title = "Add Note"

        noteTitle = findViewById(R.id.note_title)
        noteDescription = findViewById(R.id.note_description)
        save = findViewById(R.id.save)
        cancel = findViewById(R.id.cancel)

        cancel.setOnClickListener{
            finish()
        }

        save.setOnClickListener {
            saveNote()
        }
    }

    fun saveNote(){
        val title : String = noteTitle.text.toString()
        val description : String = noteDescription.text.toString()

        val intent = Intent()
        intent.putExtra("title", title)
        intent.putExtra("description", description)
        setResult(RESULT_OK, intent)
        finish()
    }
}