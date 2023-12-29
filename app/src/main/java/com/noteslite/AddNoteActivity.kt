package com.noteslite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.noteslite.databinding.ActivityAddNoteActicityBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteActicityBinding
    private var db = NotesDatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteActicityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            finish();
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show();
        }
    }
}