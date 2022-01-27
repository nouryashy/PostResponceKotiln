package com.example.postresponcekotiln

import android.app.Application
import com.example.postresponcekotiln.PostModel
import androidx.lifecycle.MutableLiveData
import com.example.postresponcekotiln.PostRepository
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class PostViewModel(application: Application) : AndroidViewModel(application) {
    private val postRepository = PostRepository(application)

   fun getAllPosts ():LiveData<List<PostModel>>{
       return postRepository.getAllPro()
   }


}