package ru.maxmvaas.lesson_5_vasilev

data class Service(
    val name: String,
    val description: String,
    val adress: String,
    val isFavorite: Boolean = false,
    val image: Int
)
