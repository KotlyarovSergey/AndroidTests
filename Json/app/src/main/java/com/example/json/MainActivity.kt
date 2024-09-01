package com.example.json

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.json.databinding.ActivityMainBinding
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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
            val dataToJson = Json.encodeToString(bigData)
            binding.textView.text = dataToJson
        }

        binding.buttonDeserializable.setOnClickListener {
            val text = binding.textView.text.toString()
            try {
                val bigData = Json.decodeFromString<BigData>(text)
                binding.tvDeserializable.text = bigData.toString()
            } catch (exception: SerializationException){
                println("SerializationException: $(exception.message)")
            } catch (exception: IllegalArgumentException){
                println("IllegalArgumentException: $(exception.message)")
            }
        }
    }
}