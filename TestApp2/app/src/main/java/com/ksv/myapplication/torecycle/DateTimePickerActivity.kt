package com.ksv.myapplication.torecycle

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.ksv.myapplication.R
import com.ksv.myapplication.databinding.ActivityDateTimePickerBinding
import java.util.Calendar

class DateTimePickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDateTimePickerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dateButton.setOnClickListener { dateOnClickListener() }
        binding.timeButton.setOnClickListener { timeOnClickListener() }
    }

    private fun dateOnClickListener(){
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("title text")
            .setPositiveButtonText("Yes")
            .setNegativeButtonText("No")
            .build()

        datePicker.addOnPositiveButtonClickListener { timeInMills ->
            // получаем веремя в миллисикундах
            // переводим его в дату
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMills
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH) + 1
            val year = calendar.get(Calendar.YEAR)
            val date = "$day.$month.$year"
            binding.dateText.text = date
        }
        datePicker.show(supportFragmentManager, datePicker::class.java.name)
    }

    private fun timeOnClickListener(){
        val timePicker = MaterialTimePicker.Builder()
            .setTitleText("Title")
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .build().apply {
                addOnPositiveButtonClickListener {
                    val hour = this.hour
                    val minute = this.minute
                    val time = "$hour:$minute"
                    binding.timeText.text = time
                }
            }
        timePicker.show(supportFragmentManager, timePicker::class.java.name)
    }
}
