package com.example.gson

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("val_a" ) val a: Int,
    @SerializedName("val_b" ) val b: String
)
