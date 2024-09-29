package com.hfad.roomtest.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.hfad.roomtest.Dependencies
import com.hfad.roomtest.R
import com.hfad.roomtest.databinding.FragmentAddPurchaseBinding
import com.hfad.roomtest.entities.Group
import com.hfad.roomtest.entities.Purchase
import com.hfad.roomtest.entities.Shop
import kotlinx.coroutines.launch

class AddPurchaseFragment : Fragment() {
    private var _binding: FragmentAddPurchaseBinding? = null
    private val binding get() = _binding!!
    private lateinit var shops: List<Shop>
    private lateinit var groups: List<Group>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPurchaseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillGroupSpinner()
        fillShopSpinner()
        binding.buttonDone.setOnClickListener { buttonDoneOnClickListener() }
    }

    private fun fillShopSpinner(){
        val shopsDao = Dependencies.getShopsDao()
        lifecycleScope.launch {
            shops = shopsDao.getAllShops()
            val stringList = shops.map { it.name }
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                stringList)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.sinnerShop.adapter = adapter
        }
    }

    private fun fillGroupSpinner() {
        val groupsDao = Dependencies.getGroupsDao()
        lifecycleScope.launch {
            groups = groupsDao.getAllGroups()
            val stringList = groups.map { it.name }
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                stringList
            )
            adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            binding.spinnerGroup.adapter = adapter
        }
    }

    private fun buttonDoneOnClickListener(){
        binding.textView.text = ""
        if(binding.editDate.text.isNotBlank() && binding.editProduct.text.isNotBlank()){
            val date = binding.editDate.text.toString()
            var position = binding.spinnerGroup.selectedItemPosition
            val groupId = groups[position].id
            position = binding.sinnerShop.selectedItemPosition
            val shopId = shops[position].id
            val comment = binding.editComment.text.toString()
            val productId = 2   // !!!!!!!!!!!!
            val purchase = Purchase(
                date = date,
                shopId = shopId,
                productId = productId,
                groupId = groupId,
                comment = comment
            )
            val purchasesDao = Dependencies.getPurchasesDao()
            lifecycleScope.launch { purchasesDao.insert(purchase) }
            binding.textView.text = "OK"
        }
    }
}