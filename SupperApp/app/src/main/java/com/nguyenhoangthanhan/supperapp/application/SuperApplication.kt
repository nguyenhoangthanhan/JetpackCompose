package com.nguyenhoangthanhan.supperapp.application

import android.app.Application
import com.google.firebase.FirebaseApp

class SuperApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}