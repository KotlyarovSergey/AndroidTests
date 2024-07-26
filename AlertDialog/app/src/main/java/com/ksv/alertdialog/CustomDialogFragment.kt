package com.ksv.alertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CustomDialogFragment(
    private val title: String,
    private val message: String,
): DialogFragment() {
    // Use this instance of the interface to deliver action events.
    private lateinit var listener: NoticeDialogListener

    // The activity that creates an instance of this dialog fragment must
    // implement this interface to receive event callbacks. Each method passes
    // the DialogFragment in case the host needs to query it.
    interface NoticeDialogListener {
        //        fun onDialogPositiveClick(dialog: DialogFragment)
        fun onCustomDialogPositiveClick()
        //        fun onDialogNegativeClick(dialog: DialogFragment)
        fun onCustomDialogNegativeClick()
        fun onCustomDialogCanceled()
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener.
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host activity implements the callback interface.
        try {
            // Instantiate the NoticeDialogListener so you can send events to the host.
            listener = context as NoticeDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface. Throw exception.
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        listener.onCustomDialogCanceled()
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)

            builder
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes") { dialog, id ->
                    // Send the positive button event back to the host activity.
//                    listener.onDialogPositiveClick(this)
                    listener.onCustomDialogPositiveClick()
                }
                .setNegativeButton("No") { dialog, id ->
                    // User cancelled the dialog.
//                    listener.onDialogNegativeClick(this)
                    listener.onCustomDialogNegativeClick()
                }
            // Create the AlertDialog object and return it.
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }
}