package ru.maxmvaas.homework

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    companion object {
        fun createStartIntent(context: Context): Intent {
            return Intent(context, SecondActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val editText = findViewById<EditText>(R.id.editText)
        val students = HashMap<Long, Student>()
        editText.setOnKeyListener { _, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val student = editText.text.toString()
                val parts = student.split(" ")
                val id = System.currentTimeMillis()
                students[id] = Student(id, parts[0], parts[1], parts[2], parts[3])
                Toast.makeText(this, "Ученик добавлен!", Toast.LENGTH_SHORT).show()
                editText.text.clear()
                return@setOnKeyListener true
            }
            false
        }
        val button = findViewById<Button>(R.id.show)
        val textView = findViewById<TextView>(R.id.showText)
        button.setOnClickListener {
            textView.text = " "
            for (student in students) {
                textView.append((student.value).getInfo() + "\n")
            }
        }
    }
}

class Student() {
    private var id: Long = 0
    private lateinit var name: String
    private lateinit var surname: String
    private lateinit var grade: String
    private lateinit var birthdayYear: String

    constructor(id: Long, name: String, surname: String, grade: String, birthdayYear: String) : this() {
        this.id = id
        this.name = name
        this.surname = surname
        this.grade = grade
        this.birthdayYear = birthdayYear
    }

    fun getInfo(): String {
        return "$id $name $surname $grade $birthdayYear"
    }
}