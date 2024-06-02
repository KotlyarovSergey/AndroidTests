package com.ksv.moshitest

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cat(
    @Json(name = "name")
    val name: String,
    @Json(name = "age")
    val age: Int,
    @Json(name = "color")
    val color: Int
)