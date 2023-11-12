package com.nguyenhoangthanhan.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nguyenhoangthanhan.newsinshort.ui.components.Loader
import com.nguyenhoangthanhan.newsinshort.ui.components.NewList
import com.nguyenhoangthanhan.newsinshort.ui.viewmodels.NewsViewModel
import com.nguyenhoangthanhan.utilities.ResourceState

const val TAG = "HomeScreen_Tag"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsRes by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState()
    VerticalPager(pageCount = ) {
        
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        when(newsRes){
            is ResourceState.Loading->{
                Log.d(TAG, "Inside_Loading")
                Loader()
            }
            is ResourceState.Success->{
                val response = (newsRes as ResourceState.Success).data
                Log.d(TAG, "Inside_Success.response = " +
                        "response.status: ${response.status};" +
                        "response.totalResults: ${response.totalResults}")
                NewList(response)
            }
            is ResourceState.Error->{
                val error = (newsRes as ResourceState.Error)
                Log.d(TAG, "Inside_Error: $error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}