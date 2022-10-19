package com.malikazizali.makeupappdiwithmvvm.network

import com.malikazizali.makeupappdiwithmvvm.model.DataResponseMakeup
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestfulApi {
    @GET("products.json")
    fun getAllProduct(): Call<List<DataResponseMakeup>>

    @GET("products.json?brand={brand}")
    fun getProductDetail(@Path("brand") brand : String): Call<List<DataResponseMakeup>>
}