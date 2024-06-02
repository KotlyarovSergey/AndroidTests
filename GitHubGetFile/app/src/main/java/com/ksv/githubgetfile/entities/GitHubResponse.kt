package com.ksv.githubgetfile.entities

interface GitHubResponse {
    val name: String
    val sha: String
//    val size: Long
    val encoding: String
//    val content: String
}