package com.ksv.navgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.ksv.navgraph.databinding.FragmentBaseBinding

class BaseFragment : Fragment() {
    private var _binding: FragmentBaseBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBaseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.alphaButton.setOnClickListener {
            findNavController().navigate(R.id.action_baseFragment_to_alphaFragment)
        }
        binding.sberButton.setOnClickListener {
            findNavController().navigate(R.id.action_baseFragment_to_sberFragment)
        }
        binding.tbankButton.setOnClickListener {
            findNavController().navigate(R.id.action_baseFragment_to_TBankFragment)
        }
        binding.vtbButton.setOnClickListener {
            findNavController().navigate(R.id.action_baseFragment_to_vtbFragment)
        }


    }
}