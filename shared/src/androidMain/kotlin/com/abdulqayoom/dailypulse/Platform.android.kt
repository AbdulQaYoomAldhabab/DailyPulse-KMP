package com.abdulqayoom.dailypulse

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round


actual class Platform() {

    actual var osName: String
        get() = "Android"
        set(value) {}
    actual var osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
        set(value) {}
    actual var deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
        set(value) {}
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        Log.d(
            "Daily Pulse",
            "($osName, $osVersion, $deviceModel, $density}"
        )
    }


}