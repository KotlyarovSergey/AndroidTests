package com.ksv.alertdialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ksv.alertdialog.databinding.FragmentTestBinding

class TestFragment : Fragment(){
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
        binding.backButton.setOnClickListener {
            activity?.finish()
//            requireActivity().finish()
        }
        binding.dialogButton.setOnClickListener {
//            val dialog = ActivityDialogFragment()
//            dialog.show(parentFragmentManager, "USER_DIALOG_FRAGMENT")
            binding.messageText.text = "Click"
        }
    }

}