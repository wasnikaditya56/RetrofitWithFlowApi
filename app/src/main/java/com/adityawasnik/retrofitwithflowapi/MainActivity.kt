package com.adityawasnik.retrofitwithflowapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adityawasnik.retrofitwithflowapi.Adapter.PostAdapter
import com.adityawasnik.retrofitwithflowapi.Model.Post
import com.adityawasnik.retrofitwithflowapi.Repository.PostRepository
import com.adityawasnik.retrofitwithflowapi.ViewModel.PostViewModel
import com.adityawasnik.retrofitwithflowapi.ViewModel.PostViewModelFactory

class MainActivity : AppCompatActivity() {

    private val TAG = "main"
    private lateinit var recyclerView: RecyclerView
    private lateinit var  progressBar: ProgressBar
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         progressBar = findViewById(R.id.progressBar)

        initUi()
        val postViewModelFactory = PostViewModelFactory(PostRepository())
        postViewModel = ViewModelProvider(this, postViewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postData.observe(this, Observer {
            Log.d(TAG, "onCreate: ${it[0].body}")
            postAdapter.setPostData(it as ArrayList<Post>)
            progressBar.visibility = View.GONE
            recyclerView.visibility=View.VISIBLE
        })
    }

    private fun initUi() {
        recyclerView = findViewById(R.id.recyclerView)
        postAdapter = PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}