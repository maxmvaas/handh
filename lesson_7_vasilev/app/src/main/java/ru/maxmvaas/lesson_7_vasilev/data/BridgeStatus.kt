package ru.maxmvaas.lesson_7_vasilev.data

import ru.maxmvaas.lesson_7_vasilev.data.model.Bridge

sealed class BridgeStatus {
    object Loading : BridgeStatus()
    class Data(val data: List<Bridge>) : BridgeStatus()
    class Error(val error: Exception) : BridgeStatus()
}
