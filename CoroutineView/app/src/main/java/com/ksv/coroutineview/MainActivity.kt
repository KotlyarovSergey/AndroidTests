package com.ksv.coroutineview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import com.ksv.coroutineview.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep
import java.util.Calendar
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var endTime = Calendar.getInstance()


    private var counter = 10
        private set(value) {
            field = value
            counterChanged()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
//            counter = 100
//            foo()
//            counter = 500
//            moo()
//            boo()
            too()
        }
        binding.actionButton.setOnClickListener {
            addLine("---any action---")
        }
        binding.tvResult.setOnClickListener {
            (it as TextView).text = ""
        }
    }

    private fun too() {
        val currentTime = Calendar.getInstance()
        val timeSpan = 5_000
        endTime.timeInMillis = currentTime.timeInMillis + timeSpan
        thread{
            while (isNoTime()){
                runOnUiThread {
                    addLine("tick-tack: ${lostSeconds()}")
                }
                sleep(1000)
            }
        }
    }

    private fun isNoTime(): Boolean{
        val currentTime = Calendar.getInstance()
        return currentTime < endTime
    }

    private fun lostSeconds():Int{
        val currentTime = Calendar.getInstance().timeInMillis
        return ((endTime.timeInMillis - currentTime) / 1000).toInt()


    }


    private fun addLine(text: String) {
        val before = binding.tvResult.text.toString()
        val newText = "$before\n$text"
        binding.tvResult.text = newText
    }

    private fun foo() = runBlocking {
        addLine("foo start")

        launch (Dispatchers.Main){
            sleepCoroutine()
        }
        addLine("foo end")
    }

    private suspend fun sleepCoroutine() {
        addLine("Засыпаем")
        delay(5000L)
        addLine("Просыпаемся")
    }

    private fun moo() {
        thread {
            var cnt = 3
            while (cnt > 0) {
                runOnUiThread {
                    addLine("cnt: $cnt")
                }
                sleep(1000)
                cnt--
            }
        }
    }

    private fun boo(){
        val mainLooper = Looper.getMainLooper()
        thread {
            var cnt = 5
            while (cnt > 0) {
                Handler(mainLooper).post {
                    addLine("cnt: $cnt")
                }
                sleep(3000)
                cnt--
            }
        }
    }

    private fun counterChanged() {
        addLine("counter = $counter")
    }
}