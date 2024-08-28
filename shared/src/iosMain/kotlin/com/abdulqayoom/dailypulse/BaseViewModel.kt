package com.abdulqayoom.dailypulse


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.IO

actual open class BaseViewModel {
    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    fun clear(){
        scope.cancel()
    }
}