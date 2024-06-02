package com.ksv.githubgetfile.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.ksv.githubgetfile.data.MainRepository
import com.ksv.githubgetfile.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("ksvlog", "start")
        binding.button.setOnClickListener {
            binding.textView.text = "refresh"

            val repo = MainRepository()
            lifecycleScope.launch {
                val resp = repo.getGitHubResponse()
//                val txt = "${resp?.name},  ${resp?.size}, ${resp?.encoding}"
                val txt = "${resp?.name}, ${resp?.encoding}"
                binding.textView.text = txt
            }
        }
    }
}