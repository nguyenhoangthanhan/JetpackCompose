package com.nguyenhoangthanhan.newsinshort.data.api

import com.nguyenhoangthanhan.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines/")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "7a4e21f6de664e10aac7fc11726b4fc6"
    ) : Response<NewsResponse>
}

//GET https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY