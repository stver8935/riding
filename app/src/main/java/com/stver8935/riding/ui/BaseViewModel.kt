package com.stver8935.riding.ui

import androidx.lifecycle.ViewModel
import com.stver8935.riding.domain.network.NetworkDetector
import com.stver8935.riding.domain.network.NetworkStateListener

/**
 *
 *
 * @packageName    : com.stver8935.riding.ui
 * @fileName   : BaseViewModel
 * @author     : hangihyeong
 * @since      : 2024. 10. 1.
 */
abstract class BaseViewModel:  ViewModel(),NetworkStateListener{
    private lateinit var networkDetector: NetworkDetector
    init {
        networkDetector.registerCallback()
    }

    override fun onAvailableNetwork() {
        TODO(" do work .. ")
    }

    override fun onLostNetwork() {
        TODO(" do work.. ")
    }
}