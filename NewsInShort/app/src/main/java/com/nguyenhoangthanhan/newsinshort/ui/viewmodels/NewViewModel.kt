package com.nguyenhoangthanhan.newsinshort.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewViewModel @Inject constructor() : ViewModel() {

    val value = "Value_NewViewModel"

    init {
        Log.d(TAG, "#Init block of NewsViewModel")
    }

    fun doSomething(){
        println("doSomething")
    }

    companion object{
        const val TAG = "NewViewModel_Tag"
    }
}