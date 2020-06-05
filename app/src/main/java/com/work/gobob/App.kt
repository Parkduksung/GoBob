package com.work.gobob

import android.app.Application
import android.content.Context
import com.work.gobob.data.di.repositoryModule
import com.work.gobob.data.di.sourceModule
import com.work.gobob.network.di.networkModule
import com.work.gobob.util.SharedPreferences
import com.work.gobob.viewmodel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        prefs = SharedPreferences(applicationContext)
        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    repositoryModule,
                    sourceModule,
                    networkModule,
                    viewModelModule
                )
            )
        }
    }

    fun context(): Context = applicationContext

    companion object {
        lateinit var instance: App
            private set
        lateinit var prefs: SharedPreferences
    }
}