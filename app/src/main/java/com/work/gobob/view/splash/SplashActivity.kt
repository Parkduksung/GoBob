package com.work.gobob.view.splash

import android.Manifest
import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.work.gobob.App
import com.work.gobob.R
import com.work.gobob.databinding.SplashMainBinding
import com.work.gobob.util.GPS
import com.work.gobob.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class SplashActivity : AppCompatActivity() {


    private val locationManager: LocationManager by lazy {
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    private val splashViewModel by viewModel<SplashViewModel>()

    private val permissionListener by lazy {
        object : PermissionListener {
            override fun onPermissionGranted() {
                GPS.getCurrentLocation(this@SplashActivity, locationManager)
            }

            override fun onPermissionDenied(deniedPermissions: ArrayList<String>?) {
            }
        }
    }

    private lateinit var binding: SplashMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.splash_main)

        binding.run {
            lifecycleOwner = this@SplashActivity
        }

        checkPermission()
    }


    private fun checkPermission() {
        TedPermission.with(App.instance.context())
            .setPermissionListener(permissionListener)
            .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
            .check()
    }


}
