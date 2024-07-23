package com.ksv.alertdialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksv.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActivityDialogFragment.NoticeDialogListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showDialogButton.setOnClickListener {
            showNoticeDialog()
        }

        binding.secondActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showNoticeDialog() {
        // Create an instance of the dialog fragment and show it.
        val dialog = ActivityDialogFragment()
        dialog.show(supportFragmentManager, "USER_DIALOG_ACTIVITY")
    }

    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following
    // methods defined by the NoticeDialogFragment.NoticeDialogListener
    // interface.
//    override fun onDialogPositiveClick(dialog: DialogFragment) {
    override fun onDialogPositiveClick() {
        // User taps the dialog's positive button.
        binding.messageText.text = "Yes"
    }

//    override fun onDialogNegativeClick(dialog: DialogFragment) {
    override fun onDialogNegativeClick() {
        // User taps the dialog's negative button.
        binding.messageText.text = "No"
    }

    override fun onDialogCanceled() {
        binding.messageText.text = "Cancel"
    }
}
