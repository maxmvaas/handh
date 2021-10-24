package ru.maxmvaas.lesson3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SecondActivity : AppCompatActivity() {
    companion object {
        fun createStartIntent(context: Context): Intent {
            return Intent(context, SecondActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val exitButton = findViewById<TextView>(R.id.exit_button)
        exitButton.setOnClickListener {
            Toast.makeText(this, "Выход", Toast.LENGTH_SHORT).show()
        }
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Назад", Toast.LENGTH_SHORT).show()
        }
        toolbar.setOnMenuItemClickListener {
            when (it!!.itemId) {
                R.id.edit -> {
                    Toast.makeText(this, "Что-то изменить?", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
        val editRegionButton = findViewById<ImageView>(R.id.edit_region)
        editRegionButton.setOnClickListener {
            Toast.makeText(this, "Сменить регион", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}