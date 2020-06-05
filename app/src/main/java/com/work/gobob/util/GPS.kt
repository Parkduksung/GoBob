package com.work.gobob.util

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import com.work.gobob.App
import com.work.gobob.ext.isConnectedToGPS

object GPS {
    @SuppressLint("MissingPermission")
    fun getCurrentLocation(context: Context, locationManager: LocationManager) {
        if (context.isConnectedToGPS()) {
            val locationListener = object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    if (location.longitude.isFinite() && location.latitude.isFinite()) {
                        App.prefs.longitude = location.longitude.toString()
                        App.prefs.latitude = location.latitude.toString()
                        locationManager.removeUpdates(this)
                    }
                }
                override fun onStatusChanged(
                    provider: String,
                    status: Int,
                    extras: Bundle
                ) {
                }

                override fun onProviderEnabled(provider: String) {
                }

                override fun onProviderDisabled(provider: String) {
                }
            }
            locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                0,
                0f,
                locationListener
            )
        }
    }
}


