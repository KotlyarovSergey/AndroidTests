package com.ksv.githubgetfile.data

import android.util.Log
import com.ksv.githubgetfile.entities.GitHubResponse
import kotlin.Exception

class MainRepository {

    suspend fun getGitHubResponse(): GitHubResponse? {
        try {
            Log.d("ksvlog", "try to get response")
            //val response = RetrofitInstance.getGitHubFileResponse.getGitHubFileData()
//            val response = RetrofitInstance.getPersonApiResponse.getPersonData()
            val response = RetrofitInstanceTwo.getGitHubFileResponse.getGitHubFileData()

            Log.d("ksvlog", "response code: ${response.code()}")
            if (response.isSuccessful) {
                //return response.body()

                Log.d("ksvlog", "encoding:${response.body()}")
                return null
            } else {
                Log.d("ksvlog", "response code: ${response.code()}")
            }
        } catch (ex: Exception) {
            Log.d("ksvlog", "${ex.message}")
        }

        Log.d("ksvlog", "return null")
        return null
    }
}