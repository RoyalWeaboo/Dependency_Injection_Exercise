package com.malikazizali.makeupappdiwithmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malikazizali.makeupappdiwithmvvm.model.DataResponseMakeup
import com.malikazizali.makeupappdiwithmvvm.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(var apiProduct : RestfulApi) : ViewModel(){

    lateinit var liveDataProduct: MutableLiveData<List<DataResponseMakeup>>


    init {
        liveDataProduct = MutableLiveData()
    }

    fun getliveDataCar() : MutableLiveData<List<DataResponseMakeup>> {
        return  liveDataProduct
    }

    fun callApiProduct(){
       apiProduct.getAllProduct()
        .enqueue(object : Callback<List<DataResponseMakeup>> {
            override fun onResponse(
                call: Call<List<DataResponseMakeup>>,
                response: Response<List<DataResponseMakeup>>
            ) {
                if (response.isSuccessful){
                    liveDataProduct.postValue(response.body())
                }else{
                    liveDataProduct.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<DataResponseMakeup>>, t: Throwable) {
                liveDataProduct.postValue(null)
            }

        })
    }

}