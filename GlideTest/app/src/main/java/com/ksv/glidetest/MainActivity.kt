package com.ksv.glidetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ksv.glidetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bntOne.setOnClickListener {
            Glide
                .with(this)
                .load("https://goo.gl/gEgYUd")
                .into(binding.image)
        }

        binding.bntTwo.setOnClickListener {
            Glide
                .with(this)
                .load("https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/03344/opgs/edr/ncam/NRB_694352858EDR_S0921230NCAM00594M_.JPG")
                .into(binding.image)
        }

        binding.bntThree.setOnClickListener {
            Glide
                .with(this)
//                    .with(binding.image.context)
                .load("https://goo.gl/gEgYUd")
//                .load("https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/03344/opgs/edr/ncam/NRB_694352858EDR_S0921230NCAM00594M_.JPG")
//                    .load(photo.photos.first().url)
//                .placeholder(R.drawable.ic_launcher_background)
//                .fitCenter()
                .into(binding.image)
        }
    }
}