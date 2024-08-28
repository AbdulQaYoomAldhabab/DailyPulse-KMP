package com.abdulqayoom.dailypulse

import platform.Foundation.NSLog
import platform.Foundation.version
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

//class IOSPlatform: Platform {
//    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
//}
//
//actual fun getPlatform(): Platform = IOSPlatform()
actual class Platform() {
    actual var osName: String
        get() = UIDevice.currentDevice.systemName
        set(value) {}
    actual var osVersion: String
        get() = UIDevice.currentDevice.systemVersion
        set(value) {}
    actual var deviceModel: String
        get() = UIDevice.currentDevice.model
        set(value) {}
    actual val density: Int
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun logSystemInfo() {
        NSLog("($osName, $osVersion, $deviceModel, $density}")
    }

}