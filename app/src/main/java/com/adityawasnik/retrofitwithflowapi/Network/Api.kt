package com.adityawasnik.retrofitwithflowapi.Network

import com.adityawasnik.retrofitwithflowapi.Model.Post
import retrofit2.http.GET

interface Api {

    @GET("posts")
    suspend fun getPost() : List<Post>

}