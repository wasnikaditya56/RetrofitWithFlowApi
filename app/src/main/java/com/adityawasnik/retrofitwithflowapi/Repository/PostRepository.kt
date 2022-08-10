package com.adityawasnik.retrofitwithflowapi.Repository

import com.adityawasnik.retrofitwithflowapi.Model.Post
import com.adityawasnik.retrofitwithflowapi.Network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository {

    fun getPost() : Flow<List<Post>> = flow {
        val postList  = RetrofitBuilder.api.getPost()
        emit(postList)
    }.flowOn(Dispatchers.IO)

}