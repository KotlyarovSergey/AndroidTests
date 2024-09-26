package com.hfad.roomtest.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.hfad.roomtest.Dependencies
import com.hfad.roomtest.R
import com.hfad.roomtest.databinding.FragmentFillDbBinding
import com.hfad.roomtest.entities.Group
import com.hfad.roomtest.entities.Product
import com.hfad.roomtest.entities.Shop
import kotlinx.coroutines.launch

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
        binding.radioGroup.setOnCheckedChangeListener { _, id ->
            radioGroupOnCheckedChangeListener(
                id
            )
        }
        binding.fillButton.setOnClickListener { fillButtonOnClickListener() }
        binding.showButton.setOnClickListener { showButtonOnClickListener() }
    }


    private fun radioGroupOnCheckedChangeListener(id: Int) {
        when (id) {
            binding.radioShops.id -> {
                showShops()
            }

            binding.radioGroups.id -> {
                showGroups()
            }

            binding.radioProducts.id -> {
                showProducts()
            }
        }
    }

    private fun fillButtonOnClickListener() {
        when (binding.radioGroup.checkedRadioButtonId) {
            binding.radioShops.id -> {
                fillShops()
            }

            binding.radioGroups.id -> {
                fillGroups()
            }

            binding.radioProducts.id -> {
                fillProducts()
            }
        }
    }

    private fun showButtonOnClickListener() {
        with(binding) {
            when (radioGroup.checkedRadioButtonId) {
                radioShops.id -> {
                    showShops()
                }

                radioGroups.id -> {
                    showGroups()
                }

                radioProducts.id -> {
                    showProducts()
                }
            }
        }
    }

    private fun fillShops() {
        val shops = listOf(
            Shop(0, "Магнит"),
            Shop(0, "Пиволюбов"),
            Shop(0, "33 Курицы"),
            Shop(0, "Ермолино")
        )

        val shopsDao = Dependencies.getShopsDao()
        lifecycleScope.launch {
            shops.forEach {
                shopsDao.insert(it)
            }
        }
    }

    private fun fillProducts() {
        val products = listOf(
            Product(name = "Российский"),
            Product(name = "Тильзиталь"),
            Product(name = "Ламбер"),
            Product(name = "Хадыженское"),
            Product(name = "Ческое"),
            Product(name = "СССР"),
            Product(name = "Филе"),
            Product(name = "Бедра"),
            Product(name = "Крылья"),
            Product(name = "Шея"),
            Product(name = "Окорок"),
            Product(name = "Финский"),
            Product(name = "Каневской"),
            Product(name = "Сормовская"),
            Product(name = "Селедка"),
            Product(name = "Карась половинка"),
            Product(name = "Путасу"),
            Product(name = "Тарань"),
            Product(name = "Вешенки маринованые"),
            Product(name = "Весенки сырые"),
            Product(name = "Шампиньоны сырые"),
            Product(name = "Ассорти")
        )
        val productsDao = Dependencies.getProductsDao()
        lifecycleScope.launch {
            products.forEach { productsDao.inset(it) }
        }
    }

    private fun fillGroups() {
        val groups = listOf(
            Group(name = "Сыр"),
            Group(name = "Пиво"),
            Group(name = "Мясо"),
            Group(name = "Колбаса"),
            Group(name = "Рыба"),
            Group(name = "Грибы")
        )
        val groupsDao = Dependencies.getGroupsDao()
        lifecycleScope.launch {
            groups.forEach { groupsDao.insert(it) }
//            groups.forEach { groupsDao.insertUnique(it.name) }
        }
    }

    private fun showShops() {
        val shopsDao = Dependencies.getShopsDao()
        lifecycleScope.launch {
            val shops = shopsDao.getAllShops()
            val text = shops.toString()
            binding.textView.text = text
        }
    }

    private fun showProducts() {
        val productsDao = Dependencies.getProductsDao()
        lifecycleScope.launch {
            val products = productsDao.getAllProducts()
            val text = products.map { "${it.id}: ${it.name}" }.joinToString("\n")
            binding.textView.text = text
        }
    }

    private fun showGroups() {
        val groupsDao = Dependencies.getGroupsDao()
        lifecycleScope.launch {
            val groups = groupsDao.getAllGroups()
            val text = groups.toString()
            binding.textView.text = text
        }
    }
}