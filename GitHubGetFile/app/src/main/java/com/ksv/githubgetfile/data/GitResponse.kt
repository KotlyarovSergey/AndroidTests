package com.ksv.githubgetfile.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitResponse(
    @Json(name="name") val name: String,
    @Json(name="sha") val sha: String,
//    @Json(name="size") override val size: Long,
    @Json(name="encoding") val encoding: String
)
