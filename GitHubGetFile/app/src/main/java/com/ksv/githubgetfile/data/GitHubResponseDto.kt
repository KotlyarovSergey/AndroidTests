package com.ksv.githubgetfile.data

import com.ksv.githubgetfile.entities.GitHubResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GitHubResponseDto(
    @Json(name="name") override val name: String,
    @Json(name="sha") override val sha: String,
//    @Json(name="size") override val size: Long,
    @Json(name="encoding") override val encoding: String
//    @Json(name="content") override val content: String
) : GitHubResponse
