package com.ksv.readwritefiles

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ksv.readwritefiles.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.readButton.setOnClickListener {
            binding.outText.text = readFromFile()
        }

        binding.writeButton.setOnClickListener {
            appendToFile(binding.inputText.text.toString())
//            writeToFile(binding.inputText.text.toString())
        }

        binding.existButton.setOnClickListener {
            Toast.makeText(this, "isFileExist: ${isFileExist()}", Toast.LENGTH_SHORT).show()
        }

        binding.deleteButton.setOnClickListener {
            deleteFile()
        }
    }

    private fun isFileExist():Boolean{
//        val file = File(FILE_NAME)
        val file = File(filesDir.absolutePath, FILE_NAME)
        return file.exists()
    }

    private fun deleteFile(){
//        val file = File(FILE_NAME)
        val file = File(filesDir.absolutePath, FILE_NAME)
        file.delete()
    }

    private fun writeToFile(text: String){
        val file:String = FILE_NAME
        val data:String = text
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
            Log.d("ksvlog", "file write OK")
        }catch(e: Exception){
            e.printStackTrace()
        }
    }

    private fun appendToFile(text: String){
        val file:String = FILE_NAME
        val data:String = "$text\n"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_APPEND)
            fileOutputStream.write(data.toByteArray())
            Log.d("ksvlog", "file write OK")
        }catch(e: Exception){
            e.printStackTrace()
        }
    }

    private fun readFromFile(): String{
        var fileInputStream: FileInputStream? = null
        fileInputStream = openFileInput(FILE_NAME)
        val inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        while(run {
                text = bufferedReader.readLine()
                text
            } != null) {
            stringBuilder.append(text.orEmpty())
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }

    companion object{
        private const val FILE_NAME = "myfile.txt"
    }
}