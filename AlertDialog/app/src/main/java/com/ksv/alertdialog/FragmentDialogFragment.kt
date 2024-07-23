package com.ksv.alertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class FragmentDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)

            builder
                .setMessage("Your chose")
                .setPositiveButton("Yes") { dialog, id ->
                    // Send the positive button event back to the host activity.


                }
                .setNegativeButton("No") { dialog, id ->
                    // User cancelled the dialog.

                    val intent = Intent()
                    targetFragment
                }
            // Create the AlertDialog object and return it.
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }
}