package com.nguyenhoangthanhan.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nguyenhoangthanhan.newsinshort.ui.components.EmptyStateComponent
import com.nguyenhoangthanhan.newsinshort.ui.components.Loader
import com.nguyenhoangthanhan.newsinshort.ui.components.NewRowComponent
import com.nguyenhoangthanhan.newsinshort.ui.viewmodels.NewsViewModel
import com.nguyenhoangthanhan.utilities.ResourceState

const val TAG = "HomeScreen_Tag"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsRes by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
    )
    VerticalPager(
        modifier = Modifier.fillMaxSize(),
        pageCount = 100,
        state = pagerState,
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->
        when (newsRes) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsRes as ResourceState.Success).data
                Log.d(
                    TAG, "Inside_Success.response = " +
                            "response.status: ${response.status};" +
                            "response.totalResults: ${response.totalResults}"
                )

                if (response.articles.isNotEmpty()){
                    EmptyStateComponent()
//                    NewRowComponent(page, response.articles[page])
                }else{
                    EmptyStateComponent()
                }
            }

            is ResourceState.Error -> {
                val error = (newsRes as ResourceState.Error)
                Log.d(TAG, "Inside_Error: $error")
            }
        }

    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}