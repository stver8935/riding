package com.stver8935.riding

import android.app.Application
import com.stver8935.riding.utils.LogManager

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        LogManager.initialize()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}