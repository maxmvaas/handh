package ru.maxmvaas.lesson_5_vasilev

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    companion object {
        fun createStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<MaterialButton>(R.id.goToFourth).setOnClickListener {
            startActivity(FourthActivity.createStartIntent(this, System.currentTimeMillis()))
        }
        findViewById<MaterialButton>(R.id.goToSecond).setOnClickListener {
            startActivity(SecondActivity.createStartIntent(this))
        }
        findViewById<MaterialButton>(R.id.goToSixth).setOnClickListener {
            startActivity(SixthActivity.createStartIntent(this))
        }
    }
}