package com.ksv.navgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ksv.navgraph.databinding.FragmentTBankBinding

class TBankFragment : Fragment() {
    private var _binding: FragmentTBankBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTBankBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.alphaButton.setOnClickListener{
            findNavController().navigate(R.id.action_TBankFragment_to_alphaFragment)
        }
        binding.sberButton.setOnClickListener {
            findNavController().navigate(R.id.action_TBankFragment_to_sberFragment)
        }
    }
}