package com.example.postresponcekotiln

import android.annotation.SuppressLint
import android.app.Application

import androidx.lifecycle.MutableLiveData

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostRepository(application: Application) {
    private val mProjectItems: List<PostModel>? = null
    private val mutableLiveData: MutableLiveData<List<PostModel>> = MutableLiveData()
    var retrofitClient = RetrofitClient()

    @SuppressLint("CheckResult")
    fun getAllPro(): MutableLiveData<List<PostModel>> {

//        var obserable: Single<List<PostModel>> = retrofitClient.getApi()!!.getPosts()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//        obserable.subscribe({ o -> mutableLiveData.setValue(o) }) { e ->
//        }
        return mutableLiveData
    }


}