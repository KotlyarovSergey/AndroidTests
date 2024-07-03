package com.ksv.gb.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.marginTop
import com.ksv.gb.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding.post) {
            topText.text = "верхняя строчка, настроенная из кода"
            bottomText.text = "нижняя строчка, настроенная из кода"

            val button = getButton()
            button.setOnClickListener {
                topText.text = "Обрабочик клика кнопки"
            }
            bottomFrame.addView(button)

        }

    }

    private fun getButton(): Button{
        val button = Button(this)
        with(button) {
            text = "Кнопка созданная из кода"

        }
        return button
    }
}