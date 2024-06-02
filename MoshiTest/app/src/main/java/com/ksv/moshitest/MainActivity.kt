package com.ksv.moshitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.ksv.moshitest.R
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvFromJson = findViewById<TextView>(R.id.tvFromJson)
        val tvToJson = findViewById<TextView>(R.id.tvToJson)



        tvToJson.text = "data class to Json"
        tvFromJson.text = "Json to data class"

        val jsonText = "{\"name\":\"Мурзик\",\"color\":-16777216,\"age\":9}"
//
        val moshi = Moshi.Builder().build()
        try {
            val jsonAdapter: JsonAdapter<Cat> = moshi.adapter(
                Cat::class.java
            )
            val murzik = jsonAdapter.fromJson(jsonText)
            tvFromJson.text = murzik.toString()

        }catch (ex: Exception){
            Log.d("ksvlog", ex.message.toString())

        }
    }
}