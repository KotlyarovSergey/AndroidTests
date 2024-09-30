package com.ksv.autocompletetextview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.ksv.autocompletetextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataList: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        dataList = resources.getStringArray(R.array.input_array).sorted().toMutableList()
        fill()

        binding.addButton.setOnClickListener {
            dataList.add(binding.completeTextView.text.toString())
            dataList.sort()
            binding.tvStatus.text = binding.completeTextView.text.toString()
            fill()
        }
    }

    private fun fill() {
        binding.completeTextView.setAdapter(
            ArrayAdapter(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                dataList
            )
        )
    }
}