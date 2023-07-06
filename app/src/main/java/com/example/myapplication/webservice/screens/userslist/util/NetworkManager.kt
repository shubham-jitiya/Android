package com.example.myapplication.webservice.screens.userslist.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import androidx.lifecycle.LiveData

class NetworkManager(private val context: Context) : LiveData<NetworkStatus>() {

    private lateinit var connectivityManager: ConnectivityManager
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    override fun onActive() {
        super.onActive()
        startNetworkCallback()
    }

    override fun onInactive() {
        super.onInactive()
        stopNetworkCallback()
    }

    private fun startNetworkCallback() {
        connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        networkCallback = createNetworkCallback()
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    private fun stopNetworkCallback() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    private fun createNetworkCallback() = object : ConnectivityManager.NetworkCallback() {
        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            val status =
                if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
                    NetworkStatus.Connected
                } else {
                    NetworkStatus.Disconnected
                }
            postValue(status)
        }

        override fun onLost(network: Network) {
            postValue(NetworkStatus.Disconnected)
        }
    }
}