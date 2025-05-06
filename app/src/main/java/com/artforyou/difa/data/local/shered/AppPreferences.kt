package com.artforyou.difa.data.local.shered

import android.content.Context
import javax.inject.Inject

class AppPreferences @Inject constructor(context: Context) {
    companion object {
        private const val PREF_NAME = "my_app_pref"
        private const val FIRST_INSTALL_KEY = "first_install"
    }

    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setFirstInstall(isFirstTime: Boolean) {
        preferences.edit().putBoolean(FIRST_INSTALL_KEY, isFirstTime).apply()
    }

    fun isFirstInstall(): Boolean {
        return preferences.getBoolean(FIRST_INSTALL_KEY, true)
    }
}