package com.nguyenhoangthanhan.newsinshort

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "#NewApplication#onCreate")
    }

    companion object{
        const val TAG = "NewsApplication_Tag"
    }
}