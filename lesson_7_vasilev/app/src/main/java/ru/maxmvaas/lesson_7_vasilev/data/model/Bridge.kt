package ru.maxmvaas.lesson_7_vasilev.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import ru.maxmvaas.lesson_7_vasilev.R
import java.util.Calendar
import kotlin.math.abs

@Parcelize
data class Bridge(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("divorces") val divorces: List<Divorce>,
    @SerializedName("photo_close_url") val photoCloseUrl: String?,
    @SerializedName("photo_open_url") val photoOpenUrl: String?,
    var isNeedToRemind: Boolean = false
) : Parcelable {

    companion object {
        const val STATUS_NORMAL = R.drawable.ic_bridge_normal
        const val STATUS_SOON = R.drawable.ic_bridge_soon
        const val STATUS_LATE = R.drawable.ic_bridge_late
    }

    fun getStatus(): Int {
        val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) * 60 + Calendar.getInstance().get(Calendar.MINUTE)
        for (divorce in divorces) {
            val divorceStart = divorce.start!!.split(":").let {
                it[0].toInt() * 60 + it[1].toInt()
            }
            val divorceEnd = divorce.end!!.split(":").let {
                it[0].toInt() * 60 + it[1].toInt()
            }
            if (currentTime in divorceStart..divorceEnd) {
                return STATUS_LATE
            } else if (abs(divorceStart - currentTime) <= 60) {
                return STATUS_SOON
            }
        }
        return STATUS_NORMAL
    }
}
