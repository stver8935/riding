package com.stver8935.riding

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class App: Application() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private lateinit var connectivityManager: ConnectivityManager
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    override fun onCreate() {
        super.onCreate()

        connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        networkCallback = object : ConnectivityManager.NetworkCallback(){
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
            }
        }

        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    override fun onTerminate() {
        super.onTerminate()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}