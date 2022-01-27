package com.example.postresponcekotiln

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



class RetrofitClient {
    var BASE_URL = "https://jsonplaceholder.typicode.com/"


    private var apiInterface: APIInterface? = null

    private var retrofit: Retrofit? = null
    fun getApi(): APIInterface? {
        if (apiInterface == null) {

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiInterface = retrofit!!.create(APIInterface::class.java)
        }
        return apiInterface
    }
}