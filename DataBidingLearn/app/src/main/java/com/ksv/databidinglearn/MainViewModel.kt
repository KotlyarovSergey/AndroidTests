package com.ksv.databidinglearn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private val _state = MutableStateFlow<State>(State.Insufficient)
    val state = _state.asStateFlow()

    fun stateChange(){
        _state.value = when(_state.value){
            State.Search -> State.Normal
            State.Normal -> State.Insufficient
            State.Insufficient -> State.Search
        }
    }
}