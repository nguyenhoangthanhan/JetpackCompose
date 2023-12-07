@file:OptIn(ExperimentalFoundationApi::class)

package com.nguyenhoangthanhan.uxwithmaterial3.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Games
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.MaterialAppRouter
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.Screen
import com.nguyenhoangthanhan.uxwithmaterial3.navigation.SystemBackButtonHandler

data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)

@Composable
fun SwipeableTabRowsScreen() {
    val tabItems = listOf(
        TabItem(
            title = "Home",
            unselectedIcon = Icons.Outlined.Home,
            selectedIcon = Icons.Filled.Home
        ),
        TabItem(
            title = "Browse",
            unselectedIcon = Icons.Outlined.ShoppingCart,
            selectedIcon = Icons.Filled.ShoppingCart
        ),
        TabItem(
            title = "Account",
            unselectedIcon = Icons.Outlined.AccountCircle,
            selectedIcon = Icons.Filled.AccountCircle
        ),
        TabItem(
            title = "Email",
            unselectedIcon = Icons.Outlined.Email,
            selectedIcon = Icons.Filled.Email
        ),
        TabItem(
            title = "Game",
            unselectedIcon = Icons.Outlined.Games,
            selectedIcon = Icons.Filled.Games
        ),
        TabItem(
            title = "Book",
            unselectedIcon = Icons.Outlined.Book,
            selectedIcon = Icons.Filled.Book
        ),
    )
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pageState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(
        key1 = selectedTabIndex,
        block = {
            pageState.animateScrollToPage(selectedTabIndex)
        }
    )
    LaunchedEffect(
        key1 = pageState.currentPage,
        key2 = pageState.isScrollInProgress,
        block = {
            if (!pageState.isScrollInProgress){
                selectedTabIndex = pageState.currentPage
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(text = tabItem.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) tabItem.selectedIcon
                            else tabItem.unselectedIcon,
                            contentDescription = tabItem.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = tabItems[index].title)
            }
        }
    }

    SystemBackButtonHandler {
        MaterialAppRouter.navigateTo(Screen.HomeScreen)
    }
}