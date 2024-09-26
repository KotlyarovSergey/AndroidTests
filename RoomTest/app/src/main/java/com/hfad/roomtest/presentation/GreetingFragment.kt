package com.hfad.roomtest.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.hfad.roomtest.R
import com.hfad.roomtest.databinding.FragmentGreetingBinding

class GreetingFragment : Fragment() {
    private var _binding: FragmentGreetingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGreetingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFillDb.setOnClickListener { buttonFillDbListener() }
        binding.buttonAddPurchase.setOnClickListener { buttonAddPurchaseOnClickListener() }
    }

    private fun buttonFillDbListener(){
        parentFragmentManager.commit {
            replace<FillDbFragment>(R.id.fragment_container_view)
            addToBackStack(FillDbFragment::class.java.name)
        }
    }

    private fun buttonAddPurchaseOnClickListener(){
        parentFragmentManager.commit {
            replace<AddPurchaseFragment>(R.id.fragment_container_view)
            addToBackStack(AddPurchaseFragment::class.java.name)
        }
    }
}