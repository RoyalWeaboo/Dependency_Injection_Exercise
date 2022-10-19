package com.malikazizali.makeupappdiwithmvvm.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.malikazizali.makeupappdiwithmvvm.databinding.ItemProductBinding
import com.malikazizali.makeupappdiwithmvvm.model.DataResponseMakeup

class ProductAdapter (var listproduct : List<DataResponseMakeup>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

//    var onDelete : ((DataResponseMakeup)->Unit)? = null
//    var onDetail : ((DataResponseMakeup)->Unit)? = null

    class ViewHolder(var binding : ItemProductBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        var view = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.name.text = listproduct!![position].name
        holder.binding.brand.text = listproduct!![position].brand
        holder.binding.price.text = "$. "+listproduct!![position].price
        Glide.with(holder.itemView.context).load(listproduct!![position].imageLink).into(holder.binding.img)

    }

    override fun getItemCount(): Int {
        return listproduct.size
    }
}