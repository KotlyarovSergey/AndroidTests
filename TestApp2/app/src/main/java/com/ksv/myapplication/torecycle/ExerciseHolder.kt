package com.ksv.myapplication.torecycle

import android.graphics.Color
import android.provider.CalendarContract.Colors
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ksv.myapplication.databinding.ExerciseItemBinding

class ExerciseHolder(item: View) : RecyclerView.ViewHolder(item) {
    val binding = ExerciseItemBinding.bind(item)

    fun bind(exercise: Exercise, wrong: Boolean) = with(binding) {
        tvFirstNumber.text = exercise.number1.toString()
        tvMathSign.text = exercise.sign.toString()
        tvSecondNumber.text = exercise.number2.toString()
//        if(wrong){
//            etResult.setBackgroundColor(Color.RED)
//        }else{
//            etResult.setBackgroundColor(Color.WHITE)
//        }

//        card.setOnClickListener{
//            etResult.setText(exercise.result.toString())
//        }

        val backgr = etResult.background

        etResult.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (etResult.text.isNotEmpty()) {
                    val input = etResult.text.toString().toInt()
                    if (input == exercise.result) {
                        etResult.setBackgroundColor(Color.GREEN)
//                        etResult.setTextColor(Color.GREEN)
                    } else {
                        etResult.setBackgroundColor(Color.RED)
//                        etResult.setTextColor(Color.RED)
                    }
                } else {
                    // вернуть дефолтный бэкграунд
                    etResult.background = backgr

                }
            } else {
//                etResult.setTextColor(Color.BLACK)
               etResult.background = backgr
            }
        }

    }

    fun mark() {
//        binding.card.setBackgroundColor(Color.RED)
        //binding.layout.setBackgroundColor(Color.RED)
        binding.etResult.setBackgroundColor(Color.RED)
    }

    fun unMark() {
        val b = binding.etResult.background
        binding.etResult.background = b
    }


}