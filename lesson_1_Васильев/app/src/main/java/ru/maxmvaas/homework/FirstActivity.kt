package ru.maxmvaas.homework

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.TreeSet

class FirstActivity : AppCompatActivity() {
    companion object {
        fun createStartIntent(context: Context): Intent {
            return Intent(context, FirstActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val editText = findViewById<EditText>(R.id.editText)
        val students = TreeSet<String>()
        val addButton = findViewById<Button>(R.id.add)
        addButton.setOnClickListener {
            students.add(editText.text.toString())
            Toast.makeText(this, "Ученик добавлен!", Toast.LENGTH_SHORT).show()
            editText.text.clear()
        }
        students.toSortedSet()
        val textView = findViewById<TextView>(R.id.showText)
        val showButton = findViewById<Button>(R.id.show)
        showButton.setOnClickListener {
            for (student in students) {
                textView.append(student + "\n")
            }
        }
    }
}