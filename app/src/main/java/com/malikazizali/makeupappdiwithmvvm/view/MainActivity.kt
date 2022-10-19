package com.malikazizali.makeupappdiwithmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikazizali.makeupappdiwithmvvm.R
import com.malikazizali.makeupappdiwithmvvm.databinding.ActivityMainBinding
import com.malikazizali.makeupappdiwithmvvm.databinding.ItemProductBinding
import com.malikazizali.makeupappdiwithmvvm.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmtoAdapter()
    }

    fun setVmtoAdapter(){
        val viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        viewModel.callApiProduct()
        viewModel.getliveDataCar().observe(this, Observer {
            productAdapter = ProductAdapter(it)
            if ( it != null){
                binding.rvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvMain.adapter = ProductAdapter(it)

            }

        })
    }
}