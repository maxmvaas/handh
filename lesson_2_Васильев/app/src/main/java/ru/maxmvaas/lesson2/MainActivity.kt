package ru.maxmvaas.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstActivityButton = findViewById<Button>(R.id.toFirstActivity)
        firstActivityButton.setOnClickListener {
            val intent = FirstActivity.createStartIntent(this)
            startActivity(intent)
        }
        val secondActivityButton = findViewById<Button>(R.id.toSecondActivity)
        secondActivityButton.setOnClickListener {
            val intent = SecondActivity.createStartIntent(this)
            startActivity(intent)
        }
    }


}