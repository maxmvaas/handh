package ru.maxmvaas.lesson_4_vasilev

data class DetailInfo(
    val title: String,
    val description: String,
    val image: Int,
    val isRed: Boolean
) : AdapterElement