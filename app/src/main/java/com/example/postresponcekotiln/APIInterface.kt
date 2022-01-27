package com.example.postresponcekotiln

import retrofit2.http.GET
import com.example.postresponcekotiln.PostModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response

interface APIInterface {
//rx call
//
//    @GET("posts")
//    fun getPosts(): Single<List<PostModel>>


//callBack call

    @GET("posts")
    fun getPosts(): Call<List<PostModel>>





//Coronten call

//    @GET("posts")
//    suspend fun getEmployees(): Response<List<PostModel>>

}