package com.ksv.navgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.ksv.navgraph.databinding.FragmentBaseBinding
import com.ksv.navgraph.databinding.FragmentSberBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class SberFragment : Fragment() {

    private var _binding: FragmentSberBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels(
        { findNavController().getBackStackEntry(R.id.banks_navigation) }
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSberBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sberImage.setOnClickListener {
            mainViewModel.canClose()
//            findNavController().popBackStack()
        }
        mainViewModel.canClose.onEach {
            if(it) findNavController().popBackStack()
        }.launchIn(viewLifecycleOwner.lifecycleScope)


        binding.vtbButton.setOnClickListener {
            //findNavController().navigate(R.id.action_sberFragment_to_vtbFragment)
            mainViewModel.toVtb()
        }
        mainViewModel.toVtb.onEach {
            if (it) {
                findNavController().navigate(R.id.action_sberFragment_to_vtbFragment)
//                parentFragmentManager.commit {
//                    replace<VtbFragment>(R.id.fragment_container)
//                    addToBackStack(VtbFragment::class.java.name)
//                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)


        binding.alphaButton.setOnClickListener {
            findNavController().navigate(R.id.action_sberFragment_to_alphaFragment)
        }
        binding.tbankButton.setOnClickListener {
            findNavController().navigate(R.id.action_sberFragment_to_TBankFragment)
        }
    }

}