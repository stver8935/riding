package com.stver8935.riding.domain.network

interface NetworkStateListener {
    /****
     * 네트워크 활성 상태 콜백
     */
    fun onAvailableNetwork()

    /***
     * 네트워크 비 활성 상태 콜백
     */
    fun onLostNetwork()
}