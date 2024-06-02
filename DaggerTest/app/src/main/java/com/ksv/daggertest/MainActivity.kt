package com.ksv.daggertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksv.daggertest.databinding.ActivityMainBinding
import com.ksv.daggertest.di.DaggerAppComponent

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val child = ChildClass()
//        val father = FatherClass(child)
//        val grand = GrandFatherClass(father)

        val component = DaggerAppComponent.create()
        val grand = component.grandFatherClass()
        binding.button.setOnClickListener {
            binding.textView.text = grand.getNumber().toString()
        }
    }
}