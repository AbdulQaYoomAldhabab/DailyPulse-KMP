package com.abdulqayoom.dailypulse

expect class Platform {
    var osName: String
    var osVersion: String
    var deviceModel: String
    val density: Int

    fun logSystemInfo()
}
