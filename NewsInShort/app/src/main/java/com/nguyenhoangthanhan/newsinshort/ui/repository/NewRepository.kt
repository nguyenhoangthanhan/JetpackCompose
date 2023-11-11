package com.nguyenhoangthanhan.newsinshort.ui.repository

import com.nguyenhoangthanhan.newsinshort.data.datasource.NewsDataSource
import javax.inject.Inject

class NewRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {
    suspend fun getNewsHeadline(country: String) {

    }
}