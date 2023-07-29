package com.example.noteapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.noteapp.R

class UpdateActivity : AppCompatActivity() {

    lateinit var noteTitle : EditText
    lateinit var noteDescription : EditText
    lateinit var save : Button
    lateinit var cancel : Button

    var currentId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updata)

        supportActionBar?.title = "Update Note"

        noteTitle = findViewById(R.id.update_note_title)
        noteDescription = findViewById(R.id.update_note_description)
        save = findViewById(R.id.update_save)
        cancel = findViewById(R.id.update_cancel)

        getAndSetData()

        cancel.setOnClickListener{
            finish()
        }

        save.setOnClickListener {
            updateNote()
        }
    }

    fun updateNote(){
        val title : String = noteTitle.text.toString()
        val description : String = noteDescription.text.toString()

        val intent = Intent()
        intent.putExtra("new title", title)
        intent.putExtra("new description", description)

        if(currentId != -1){
            intent.putExtra("current id", currentId)
            setResult(RESULT_OK, intent)
        }
        finish()
    }

    fun getAndSetData(){
        val currentTitle = intent.getStringExtra("current title")
        val currentDescription = intent.getStringExtra("current description")
        currentId = intent.getIntExtra("current id", -1)

        noteTitle.setText(currentTitle)
        noteDescription.setText(currentDescription)
    }
}