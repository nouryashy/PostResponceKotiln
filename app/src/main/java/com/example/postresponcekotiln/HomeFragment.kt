package com.example.postresponcekotiln

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class HomeFragment : Fragment() {


    var posttViewModel: PostViewModel? = null
    var postsList = ArrayList<PostModel>()
    var postModel: PostModel? = null

    var postRecycle: RecyclerView? = null
    var postAdapter: PostAdapter? = null

    var retrofitClient = RetrofitClient()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        posttViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
//
//
//        intRxList()

        intCallBack()

//        intCoroutine()
    }


    private fun intCallBack() {
        postRecycle = posts_recycle_view
        postRecycle!!.layoutManager = LinearLayoutManager(context)
        postAdapter = PostAdapter(requireContext())
        postRecycle!!.adapter = postAdapter
        retrofitClient.getApi()!!.getPosts().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                if (response.isSuccessful) {
                    val postList: List<PostModel> = response.body()!!
                    postAdapter!!.setList(postList)
                } else {
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {}
        })
    }


    // function for   rxjava call

//    private fun intRxList() {
//    postAdapter = PostAdapter(requireContext())
//        posttViewModel!!.getAllPosts()
//            .observe(viewLifecycleOwner, object : Observer<List<PostModel>> {
//                override fun onChanged(postModels: List<PostModel>) {
//                    postAdapter!!.setList(postModels)
//                }
//            })
//        postRecycle = posts_recycle_view
//        postRecycle!!.layoutManager = LinearLayoutManager(context)
//        postRecycle!!.adapter = postAdapter
//    }





   // function for   Coroutine call

//    private fun intCoroutine() {
//        postRecycle = posts_recycle_view
//        postRecycle!!.layoutManager = LinearLayoutManager(context)
//        postAdapter = PostAdapter(requireContext())
//        postRecycle!!.adapter = postAdapter
//        // Create Service
//        val service = retrofitClient.getApi()
//        CoroutineScope(Dispatchers.IO).launch {
//
//            // Do the GET request and get response
//            val response = service!!.getEmployees()
//
//            withContext(Dispatchers.Main) {
//                if (response.isSuccessful) {
//
//                    val postList: List<PostModel> = response.body()!!
//                    postAdapter!!.setList(postList)
//
//
//                } else {
//
//                    Log.e("RETROFIT_ERROR", response.code().toString())
//
//                }
//            }
//        }
//    }

}