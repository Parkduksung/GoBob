package com.work.gobob.util

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_FILENAME, 0)

    var longitude: String
        get() = prefs.getString(PREF_KEY_LONGITUDE, EMPTY_TEXT)!!
        set(value) = prefs.edit().putString(PREF_KEY_LONGITUDE, value).apply()

    var latitude: String
        get() = prefs.getString(PREF_KEY_LATITUDE, EMPTY_TEXT)!!
        set(value) = prefs.edit().putString(PREF_KEY_LATITUDE, value).apply()

    companion object {
        private const val PREFS_FILENAME = "prefs"
        private const val EMPTY_TEXT = ""
        private const val PREF_KEY_LONGITUDE = "longitude"
        private const val PREF_KEY_LATITUDE = "latitude"
    }
}