package com.ksv.databidinglearn

sealed class State {
    data object Normal: State()
    data object Search : State()
    data object Insufficient: State()
}