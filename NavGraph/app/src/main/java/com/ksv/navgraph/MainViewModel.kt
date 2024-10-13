package com.ksv.navgraph

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private val _canClose = MutableStateFlow<Boolean>(false)
    val canClose = _canClose.asStateFlow()

    private val _toVtb = MutableStateFlow<Boolean>(false)
    val toVtb = _toVtb.asStateFlow()

    fun canClose(){
        _canClose.value = true
    }

    fun toVtb(){
        _toVtb.value = true
    }

}