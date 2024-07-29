package com.ksv.menu.b

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.ksv.menu.R
import com.ksv.menu.databinding.ActivityBBinding

class BActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)

        when (intent.getStringExtra("FRAG")) {
            B1Fragment::class.java.name -> {
                supportFragmentManager.commit {
                    replace<B1Fragment>(R.id.fragment_container_b)
                }
            }
            B2Fragment::class.java.name -> {
                supportFragmentManager.commit {
                    replace<B2Fragment>(R.id.fragment_container_b)
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        supportActionBar?.title = "Activity B"
        return super.onCreateOptionsMenu(menu)
    }


}