package com.ksv.githubgetfile.data

import com.ksv.githubgetfile.entities.GitHubResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

//private const val BASE_URL = "https://api.github.com/repos/drewthoennes/Bored-API/contents"
private const val BASE_URL = "https://api.github.com/repos/kotlyarovsergey/maibo/contents"

object RetrofitInstanceTwo {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val getGitHubFileResponse:GetGitHubFileResponse = retrofit.create(
        GetGitHubFileResponse::class.java
    )

}

interface GetGitHubFileResponse{
//    @GET("db/activities.json")
    @GET("parser.java")
    @Headers("Accept: application/vnd.github.object+json")
    suspend fun getGitHubFileData(): Response<GitHubResponseDto>
//    suspend fun getGitHubFileData(): Response<String>
}