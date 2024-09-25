package com.hfad.roomtest.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.roomtest.R
import com.hfad.roomtest.databinding.FragmentFillDbBinding

class FillDbFragment : Fragment() {
    private var _binding: FragmentFillDbBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFillDbBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.radioGroup.setOnCheckedChangeListener { _, id ->  radioGroupOnCheckedChangeListener(id)}
        binding.fillButton.setOnClickListener { fillButtonOnClickListener() }
        binding.showButton.setOnClickListener { showButtonOnClickListener() }
    }

    private fun radioGroupOnCheckedChangeListener(id: Int){
        when(id){
            binding.radioShops.id -> {
                binding.textView.text = binding.radioShops.text
            }
            binding.radioGroups.id -> {
                binding.textView.text = binding.radioGroups.text
            }
            binding.radioProducts.id -> {
                binding.textView.text = binding.radioProducts.text
            }
        }
    }

    private fun fillButtonOnClickListener(){
        binding.textView.text = binding.fillButton.text
    }

    private fun showButtonOnClickListener(){
        binding.textView.text = binding.showButton.text
    }
}