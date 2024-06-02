package com.ksv.mvvmlivecycle

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FragmentViewModel: ViewModel() {
    private var _counter = MutableStateFlow(0)
    val counter get() = _counter.asStateFlow()

    fun incCounter(){
        _counter.value++
        Log.d("ksvlog", "FragVM counter = ${counter.value}")
    }
}