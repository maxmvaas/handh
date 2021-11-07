package ru.maxmvaas.lesson_5_vasilev

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class FifthActivityContract : ActivityResultContract<String, String>() {
    override fun createIntent(context: Context, input: String?): Intent {
        return FifthActivity.createStartIntent(context)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        return intent?.getStringExtra(FifthActivity.EXTRA_INPUT_TEXT).orEmpty()
    }
}