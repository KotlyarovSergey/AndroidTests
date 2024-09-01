package com.example.json

import kotlinx.serialization.Serializable

@Serializable
data class BigData(
    val name: String,
    val data: Data
)
