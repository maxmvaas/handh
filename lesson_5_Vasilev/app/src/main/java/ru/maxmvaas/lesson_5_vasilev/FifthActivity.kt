package ru.maxmvaas.lesson_5_vasilev

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.button.MaterialButton

class FifthActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_INPUT_TEXT = "text"
        const val DATA = "value"

        fun createStartIntent(context: Context): Intent {
            return Intent(context, FifthActivity::class.java)
        }
    }

    private val editTextValue by lazy { findViewById<EditText>(R.id.editText) }
    private val editData by lazy { findViewById<TextView>(R.id.editData) }
    private val sendText by lazy { findViewById<EditText>(R.id.sendData) }
    private var data = Data("there is nothing")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        findViewById<MaterialButton>(R.id.deliverResult).setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(EXTRA_INPUT_TEXT, editTextValue.text.toString())
            })
            finish()
        }

        findViewById<MaterialButton>(R.id.saveData).setOnClickListener {
            data = Data(sendText.text.toString())
            editData.text = data.value
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(DATA, data)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        data = savedInstanceState.getParcelable(DATA)!!
    }

    override fun onResume() {
        super.onResume()
        editData.text = data.value
    }
}