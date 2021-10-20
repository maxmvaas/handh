package ru.maxmvaas.homework

import androidx.appcompat.app.AppCompatActivity

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.KeyEvent
import android.content.Intent

import java.util.TreeSet


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstActivityButton = findViewById<Button>(R.id.firstActivity)
        firstActivityButton.setOnClickListener {
            val intent = FirstActivity.createStartIntent(this)
            startActivity(intent)
        }
        val secondActivityButton = findViewById<Button>(R.id.secondActivity)
        secondActivityButton.setOnClickListener {
            val intent = SecondActivity.createStartIntent(this)
            startActivity(intent)
        }
    }
}