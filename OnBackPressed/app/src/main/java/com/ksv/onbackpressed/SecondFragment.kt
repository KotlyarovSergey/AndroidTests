package com.ksv.onbackpressed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import com.ksv.onbackpressed.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dispatcher = requireActivity().onBackPressedDispatcher
//        dispatcher.addCallback(requireActivity(), object : OnBackPressedCallback(true){
        dispatcher.addCallback(getViewLifecycleOwner(), object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                // Back is pressed... Finishing the activity
                //finish()
                Log.d("ksvlog", "Back pressed")
                val builder = AlertDialog.Builder(requireActivity())
                builder
                    .setTitle("Подрверждение")
                    .setMessage("Вернуться назад?")
                    .setPositiveButton("Да"){ _, _ ->
                        parentFragmentManager.popBackStack()
                    }
                    .setNegativeButton("Нет"){ _, _ ->
                        // do nothing
                    }
                val dialog = builder.create()
                dialog.show()
            }
        })

    }
}