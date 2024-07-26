package com.ksv.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class SecondActivity :
    AppCompatActivity(),
    ActivityDialogFragment.NoticeDialogListener,
    CustomDialogFragment.NoticeDialogListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
    override fun onDialogPositiveClick() {
        Log.d("ksvlog", "user click \"Yes\"")
    }

    override fun onDialogNegativeClick() {
        Log.d("ksvlog", "user click \"No\"")
    }

    override fun onDialogCanceled() {
        Log.d("ksvlog", "user cancel dialog")
    }

    override fun onCustomDialogPositiveClick() {
        Log.d("ksvlog", "user click \"Yes\"")
        sendToFragment("Yes")
    }

    override fun onCustomDialogNegativeClick() {
        Log.d("ksvlog", "user click \"No\"")
        sendToFragment("No")
    }

    override fun onCustomDialogCanceled() {
        Log.d("ksvlog", "user cancel dialog")
        sendToFragment("Cancel")
    }


    private fun sendToFragment(msg: String){
//        val id = findViewById<Fragment>(R.layout.fragment_test)
//        val fragment = supportFragmentManager.findFragmentById(R.layout.fragment_test)
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment != null && fragment is TestFragment){
            fragment.getUserAction(msg)
        }
    }
}