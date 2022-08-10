package com.adityawasnik.retrofitwithflowapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adityawasnik.retrofitwithflowapi.Model.Post
import com.adityawasnik.retrofitwithflowapi.R

class PostAdapter(private val context:Context, private var postList:ArrayList<Post>)
    : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))

    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        val post = postList[position]
        holder.body.text = post.body
    }

    override fun getItemCount(): Int = postList.size


    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val body: TextView = itemView.findViewById(R.id.body)
    }

    fun setPostData(postList: ArrayList<Post>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }


}