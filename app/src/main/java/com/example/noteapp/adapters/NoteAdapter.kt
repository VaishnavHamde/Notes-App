package com.example.noteapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var notes : List<Note> = ArrayList()

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewTitle : TextView = itemView.findViewById(R.id.title)
        val textViewDescription : TextView = itemView.findViewById(R.id.description)
        val cardView : CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var currentNote : Note = notes[position]

        holder.textViewTitle.text = currentNote.title
        holder.textViewDescription.text = currentNote.description
    }

    fun setNote(myNotes : List<Note>){
        this.notes = myNotes
        notifyDataSetChanged()
    }

}