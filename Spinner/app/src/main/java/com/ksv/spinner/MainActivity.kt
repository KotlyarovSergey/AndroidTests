package com.ksv.spinner

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.ksv.spinner.databinding.ActivityMainBinding
import java.time.DayOfWeek

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<CharSequence>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ArrayAdapter.createFromResource(this, R.array.cats, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner2.adapter = adapter

        binding.spinner2.onItemSelectedListener = this

        val dayOfWeek = arrayOf( "Понедельник", "Вторник", "Среда", "Четверг",
            "Котопятница", "Субкота", "Воскресенье" )
        val adapter3 = ArrayAdapter<String>(this,
            R.layout.row, R.id.weekofday, dayOfWeek
        )
        binding.spinner3.adapter = adapter3


        val adapter4 = MyCustomAdapter(this, R.layout.row, dayOfWeek)
        binding.spinner4.adapter = adapter4

    }

    fun onClickButton1(view: View){
        val textSelected  = binding.spinner2.selectedItem.toString()
        val index = binding.spinner2.selectedItemPosition
        binding.tvResult.text = "ind: $index, text: $textSelected"

    }

    fun onClickButtonChange(view: View){         //CHANGE
        val currentIndex  = binding.spinner2.selectedItemPosition
        var itemNumber = currentIndex
        while(itemNumber == currentIndex) {
            itemNumber = (0 until binding.spinner2.count).random()
        }
        binding.spinner2.setSelection(itemNumber)

    }

    fun onClickButtonGetPosition(view: View){
        val txt = binding.spinner1.selectedItem.toString()
        val pos = this.adapter.getPosition(txt)
        binding.tvResult.text = "text: $txt, position: $pos"
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        binding.tvResult.text = binding.spinner2.selectedItem.toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        binding.button1.text = "NothingSelected"
    }
}

