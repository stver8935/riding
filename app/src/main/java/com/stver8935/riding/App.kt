package com.stver8935.riding

import android.app.Application
import com.stver8935.riding.utils.LoggerManager

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        LoggerManager.initialize()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}