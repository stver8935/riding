package com.stver8935.riding.domain.network

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest

class NetworkDetector(
    private val activity: Activity,
    private val networkStateListener: NetworkStateListener
): ConnectivityManager.NetworkCallback() {
    override fun onAvailable(network: Network) {
        //super.onAvailable(network)
        networkStateListener.onAvailableNetwork()
    }

    val connManager: ConnectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkReq = NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()

    override fun onLosing(network: Network, maxMsToLive: Int) {
        super.onLosing(network, maxMsToLive)
    }

    override fun onLost(network: Network) {
        //super.onLost
        networkStateListener.onLostNetwork()
    }

    override fun onUnavailable() {
        super.onUnavailable()
    }

    override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities)
    }

    override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
        super.onLinkPropertiesChanged(network, linkProperties)
    }

    override fun onBlockedStatusChanged(network: Network, blocked: Boolean) {
        super.onBlockedStatusChanged(network, blocked)
    }

    fun registerCallback(){
        connManager.registerNetworkCallback(networkReq,this)
    }

    fun unRegisterCallback(){
        connManager.unregisterNetworkCallback(this)
    }
}