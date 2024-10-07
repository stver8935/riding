package com.stver8935.riding.domain.network

interface NetworkStateListener {
    fun onAvailableNetwork()
    fun onLostNetwork()
    fun onLosing()
    fun onLost()
    fun onUnavailable()
}