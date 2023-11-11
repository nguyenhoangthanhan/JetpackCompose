package com.nguyenhoangthanhan.newsinshort.data.datasource

import com.nguyenhoangthanhan.newsinshort.data.api.ApiService
import com.nguyenhoangthanhan.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImp @Inject constructor(
    private val apiService: ApiService
): NewsDataSource {
    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country)
    }
}