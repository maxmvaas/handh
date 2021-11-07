package ru.maxmvaas.lesson_5_vasilev

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val value: String
) : Parcelable