package com.nguyenhoangthanhan.newsinshort.data.datasource

import com.nguyenhoangthanhan.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsDataSource {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        country: String
    ): Response<NewsResponse>
}