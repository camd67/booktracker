package com.example.booktracker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var titleInput: EditText
    lateinit var authorInput: EditText
    lateinit var readCheckBox: CheckBox
    lateinit var bookListLabel: TextView
    val bookList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleInput = findViewById(R.id.inputTitle)
        authorInput = findViewById(R.id.inputAuthor)
        readCheckBox = findViewById(R.id.checkboxFinishedReading)
        bookListLabel = findViewById(R.id.lblBookList)
    }

    fun onAddBookClick(view: View) {
        val newTitle = titleInput.text.toString()
        titleInput.text.clear()

        val newAuthor = authorInput.text.toString()
        authorInput.text.clear()

        val readDisplay = if (readCheckBox.isChecked) {
            "✔️"
        } else {
            "❌"
        }
        readCheckBox.isChecked = false

        bookList.add(resources.getString(R.string.lblBookDisplay, newTitle, newAuthor, readDisplay))

        bookListLabel.text = bookList.joinToString("\n" )
    }
}
