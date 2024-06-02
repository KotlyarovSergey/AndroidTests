package com.ksv.myapplication.activityresult

import java.io.Serializable

data class InputClass(
    val data: Int,
    val msg: String,
    val flag: Boolean
): Serializable
