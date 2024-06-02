package com.ksv.databidinglearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ksv.databidinglearn.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.buttonOne.setOnClickListener {
            viewModel.stateChange()
        }

        lifecycleScope
            .launchWhenStarted {
                viewModel.state
                    .collect{
                        binding.tvOne.text = when(it){
                            State.Insufficient -> "Insufficient"
                            State.Normal -> "Normal"
                            State.Search -> "Search"
                        }
                    }
            }
    }
}