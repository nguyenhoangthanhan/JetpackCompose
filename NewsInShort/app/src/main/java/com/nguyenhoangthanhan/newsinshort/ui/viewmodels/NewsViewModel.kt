package com.nguyenhoangthanhan.newsinshort.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguyenhoangthanhan.newsinshort.data.AppConstants
import com.nguyenhoangthanhan.newsinshort.data.entity.NewsResponse
import com.nguyenhoangthanhan.newsinshort.ui.repository.NewsRepository
import com.nguyenhoangthanhan.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewsResponse>> = _news

    init {
        getNews(AppConstants.COUNTRY)
    }

    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadline(country)
                .collectLatest { newResponse ->
                    _news.value = newResponse
                }
        }
    }

    companion object {
        const val TAG = "NewViewModel_Tag"
    }
}