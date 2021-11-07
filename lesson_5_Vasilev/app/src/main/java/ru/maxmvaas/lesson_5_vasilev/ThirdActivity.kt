package ru.maxmvaas.lesson_5_vasilev

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity() {

    private val launcher = registerForActivityResult(FifthActivityContract()) { input ->
        Snackbar.make(findViewById(R.id.layout), input, Snackbar.LENGTH_SHORT).show()
    }

    companion object {
        fun createStartIntent(context: Context): Intent {
            return Intent(context, ThirdActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        findViewById<MaterialButton>(R.id.goToFirst).setOnClickListener {
            startActivity(MainActivity.createStartIntent(this))
        }
        findViewById<MaterialButton>(R.id.goToFifthToResult).setOnClickListener {
            launcher.launch("some text")
        }
        findViewById<MaterialButton>(R.id.goToFifth).setOnClickListener {
            startActivity(FifthActivity.createStartIntent(this))
        }
    }
}