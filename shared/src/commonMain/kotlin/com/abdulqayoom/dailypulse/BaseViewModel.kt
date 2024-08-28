package com.abdulqayoom.dailypulse

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope
}