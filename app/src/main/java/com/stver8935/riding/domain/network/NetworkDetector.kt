import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.stver8935.riding.domain.network.NetworkStateListener

class NetworkDetector(
    ctx: Context
) : ConnectivityManager.NetworkCallback() {

    private val connectManager: ConnectivityManager = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private val networkRequest: NetworkRequest = NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()

    private lateinit var networkStateListener: NetworkStateListener

    fun registerCallback(networkStateListener: NetworkStateListener) {
        this.networkStateListener = networkStateListener
        connectManager.registerDefaultNetworkCallback(this)
        connectManager.registerNetworkCallback(networkRequest, this)
    }

    fun unRegisterCallback() {
        connectManager.unregisterNetworkCallback(this)
    }

    override fun onAvailable(network: Network) {
        networkStateListener.onAvailableNetwork()
    }

    override fun onLosing(network: Network, maxMsToLive: Int) {
        networkStateListener.onLosing()
    }

    override fun onLost(network: Network) {
        networkStateListener.onLost()
    }

    override fun onUnavailable() {
        networkStateListener.onUnavailable()
    }
}
