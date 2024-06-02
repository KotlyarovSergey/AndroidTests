package com.ksv.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ksv.myapplication.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPreferencesBinding
    private val SAVE_NAME = "SAVE_NAME"
    private val SAVE_STRING_NAME = "STRTING_PARAM"
    private val SAVE_INT_NAME = "INT_PARAM"
    private val SAVE_FLOAT_NAME = "FLOAT_PARAM"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickSave(view: View) {
        val pref = getSharedPreferences(SAVE_NAME, MODE_PRIVATE)
        val prefEditor = pref.edit()
        val text = binding.etTetxtToSave.text.toString()
        val number = (1..1000).random()
        val floatNumber = number * 1.7f
        prefEditor.putString(SAVE_STRING_NAME, text)
        prefEditor.putFloat(SAVE_FLOAT_NAME, floatNumber)
        prefEditor.putInt(SAVE_INT_NAME, number)
        prefEditor.apply()
    }

    fun onClickLoad(view: View) {
        val pref = getSharedPreferences(SAVE_NAME, MODE_PRIVATE)
        val stringBuilder = StringBuilder()
        if (pref.contains(SAVE_STRING_NAME)) {
            val txt = pref.getString(SAVE_STRING_NAME, "")
            stringBuilder.append(txt)
            stringBuilder.append("\n")
        }

        if(pref.contains(SAVE_INT_NAME)){
            val number = pref.getInt(SAVE_INT_NAME, -1)
            stringBuilder.append(number.toString())
            stringBuilder.append("\n")
        }

        if(pref.contains(SAVE_FLOAT_NAME)){
            val fl = pref.getFloat(SAVE_FLOAT_NAME, -1f)
            stringBuilder.append(fl.toString())
        }

        binding.etLoadedText.setText(stringBuilder.toString())
    }
}