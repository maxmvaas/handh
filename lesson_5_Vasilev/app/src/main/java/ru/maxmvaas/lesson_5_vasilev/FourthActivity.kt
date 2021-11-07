package ru.maxmvaas.lesson_5_vasilev

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.util.Locale

class FourthActivity : AppCompatActivity() {
    companion object {
        private const val KEY_TIME = "KEY_TIME"

        fun createStartIntent(context: Context, time: Long): Intent {
            return Intent(context, FourthActivity::class.java).apply {
                putExtra(KEY_TIME, time)
            }
        }
    }

    private val textView by lazy { findViewById<TextView>(R.id.currentTime) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        textView.text = calculateTime()
        findViewById<MaterialButton>(R.id.goToFourth).setOnClickListener {
            startActivity(createStartIntent(this, System.currentTimeMillis()))
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        textView.text = calculateTime()
        setIntent(intent)
    }

    private fun calculateTime(): String =
        SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.US).format(intent.getLongExtra(KEY_TIME, 0L))
}
