package com.stver8935.riding.utils.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AppSchedulerProvider: SchedulerProvider {
    override fun computation(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }
    override fun ui(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}