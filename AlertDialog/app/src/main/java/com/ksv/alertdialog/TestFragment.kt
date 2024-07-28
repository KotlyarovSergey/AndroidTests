package com.ksv.alertdialog

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ksv.alertdialog.databinding.FragmentTestBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TestFragment : Fragment() {
    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val localDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss")
        val dateDimeText = localDateTime.format(formatter)
        binding.messageText.text = dateDimeText

        binding.backButton.setOnClickListener {
            activity?.finish()
//            requireActivity().finish()
        }

        binding.dialogButton.setOnClickListener {
            // диалог работает, НО!
            // листенер реализутеся в активити!
            val dialog = ActivityDialogFragment()
            dialog.show(parentFragmentManager, "USER_DIALOG_FRAGMENT")
        }

        binding.customDialogButton.setOnClickListener {
            val title = "Заголовок"
            val message = "Текст сообщения"
            val dialog = CustomDialogFragment(title, message)
            dialog.show(parentFragmentManager, "CUSTOM_DIALOG_FRAGMENT")
        }


        // ----------------------
        binding.instanceDialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(requireActivity())

            builder
                .setTitle("Заголовок")
                .setMessage("Текст сообщения")
                .setPositiveButton("Yes") { dialog, id ->
                    // Send the positive button event back to the host activity.
                    binding.messageText.text = "Yes"
                    Log.d("ksvlog", "tap \"Yes\"")
                }
                .setNegativeButton("No") { dialog, id ->
                    // User cancelled the dialog.
                    binding.messageText.text = "No"
                    Log.d("ksvlog", "tap \"No\"")
                }
//                .setOnDismissListener { dialog ->
//                    binding.messageText.text = "Dissmiss"
//                    Log.d("ksvlog", "Dissmiss")
//                }
                .setOnCancelListener { dialog ->
                    binding.messageText.text = "Cancel"
                    Log.d("ksvlog", "Cancel")
                }
            // Create the AlertDialog object and return it.
            builder.create()

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    fun getUserAction(action: String) {
        binding.messageText.text = action
    }

}