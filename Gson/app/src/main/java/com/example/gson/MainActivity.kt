package com.example.gson

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gson.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSerializable.setOnClickListener {
            val data = Data(10, "text")
            val bigData = BigData("BigData", data)
            val gson = Gson()
            val dataToJson = gson.toJson(bigData)
            binding.textView.text = dataToJson
        }

        binding.buttonDeserializable.setOnClickListener {
            val text = binding.textView.text.toString()
            try {
                val bigData = Gson().fromJson(text, BigData::class.java)
                binding.tvDeserializable.text = bigData.toString()
            } catch (exception: JsonSyntaxException){
                println(exception.message)
                binding.tvDeserializable.text = "Error"
            }
        }
    }
}