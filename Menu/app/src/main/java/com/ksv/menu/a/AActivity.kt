package com.ksv.menu.a

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.iterator
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.ksv.menu.R
import com.ksv.menu.b.B1Fragment
import com.ksv.menu.b.B2Fragment
import com.ksv.menu.b.BActivity
import com.ksv.menu.databinding.ActivityABinding

class AActivity : AppCompatActivity() {
    private lateinit var binding: ActivityABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        supportActionBar?.title = "Activity A"

        supportFragmentManager.addOnBackStackChangedListener {
            Log.d("ksvlog", "OnBackStackChangedListener")

            // visible all items
            val iterator = menu?.iterator()
            if (iterator != null) {
                for(item in iterator){
                    item.isVisible = true
                }
            }

            // get current fragment and hide respective item
            val frag = supportFragmentManager.findFragmentById(R.id.fragment_container_a)
            when(frag){
                is A1Fragment -> {
                    Log.d("ksvlog", "A1Fragment")
                    menu?.findItem(R.id.menu_a1)?.isVisible = false
                }
                is A2Fragment -> {
                    Log.d("ksvlog", "A2Fragment")
                    menu?.findItem(R.id.menu_a2)?.isVisible = false
                }
            }
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_a1 -> {
                binding.textView.text = getString(R.string.a1)
                supportFragmentManager.commit {
                    replace<A1Fragment>(R.id.fragment_container_a)
                    addToBackStack(A1Fragment::class.java.name)
                }
                true
            }
            R.id.menu_a2 -> {
                binding.textView.text = getString(R.string.a2)
                supportFragmentManager.commit {
                    replace<A2Fragment>(R.id.fragment_container_a)
                    addToBackStack(A2Fragment::class.java.name)
                }
                true
            }
            R.id.menu_b1 -> {
                binding.textView.text = getString(R.string.b1)
                val intent = Intent(this@AActivity, BActivity::class.java)
                intent.putExtra("FRAG", B1Fragment::class.java.name)
                startActivity(intent)
                true
            }
            R.id.menu_b2 -> {
                binding.textView.text = getString(R.string.b2)
                val intent = Intent(this@AActivity, BActivity::class.java)
                intent.putExtra("FRAG", B2Fragment::class.java.name)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}