package com.ksv.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ksv.myapplication.databinding.ActivityRecyclerViewBinding
import com.ksv.myapplication.torecycle.Exercise
import com.ksv.myapplication.torecycle.ExerciseAdapter

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private val adapter = ExerciseAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()





            //binding.button2.background = resources(android.R.drawable.edit_text)




    }

    fun onClickFill(view: View) {
        adapter.clear()
        repeat(10) {
            adapter.addExercise(generateExercise())
        }
    }

    private fun init() {
        binding.rcView.layoutManager = LinearLayoutManager(this)
        binding.rcView.adapter = adapter

        binding.apply {

        }
    }

    private fun generateExercise(): Exercise {
        when ((0..3).random()) {
            0 -> {
                val num1 = (1..100).random()
                val num2 = (10..99).random()
                return Exercise(num1, num2, '+', num1 + num2)
            }

            1 -> {
                val num1 = (11..99).random()
                val num2 = (1..99).random()
                return Exercise(num1 + num2, num1, '-', num2)
            }

            2 -> {
                val num1 = (1..100).random()
                val num2 = (10..99).random()
                return Exercise(num1, num2, '*', num1 * num2)
            }

            else -> {
                val num1 = (11..99).random()
                val num2 = (1..99).random()
                return Exercise(num1 * num2, num1, ':', num2)
            }
        }
    }

}