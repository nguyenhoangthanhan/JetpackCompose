package com.nguyenhoangthanhan.supperapp.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nguyenhoangthanhan.loginflow.ui.theme.Primary
import com.nguyenhoangthanhan.supperapp.R
import com.nguyenhoangthanhan.supperapp.ui.components.AppToolbar
import com.nguyenhoangthanhan.supperapp.ui.components.HeadingTextComponent
import com.nguyenhoangthanhan.supperapp.ui.components.NavigationDrawerBody
import com.nguyenhoangthanhan.supperapp.ui.components.NavigationDrawerHeader
import com.nguyenhoangthanhan.supperapp.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val TAG = "HomeScreen_TAG"

    val mDrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    homeViewModel.getUserData()

    ModalNavigationDrawer(
        drawerState = mDrawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerTonalElevation = 12.dp,
                drawerContainerColor = Primary,
                drawerContentColor = Color.Black,
                content = {
                    NavigationDrawerHeader(homeViewModel.emailId.value)
                    NavigationDrawerBody(
                        navigationDrawerItems = homeViewModel.navigationItemsList,
                        onNavigationItemClicked = {
                            Log.d(TAG, "inside_NavigationItemClicked")
                            Log.d(TAG, "${it.itemId} ${it.title}")
                        }
                    )
                }
            )
        },
        content = {

            Scaffold(
                topBar = {
                    AppToolbar(
                        toolbarTitle = stringResource(id = R.string.home),
                        logoutButtonClicked = {
                            homeViewModel.logout()
                        },
                        navigationIconClicked = {
                            scope.launch {
                                mDrawerState.open()
                            }
                        }
                    )
                }
            ) { paddingValues ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(paddingValues)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        HeadingTextComponent(value = stringResource(R.string.home_title))
                    }

                }
            }
        }
    )

}

@Preview
@Composable
fun DefaultPreviewOfHomeScreen() {
    HomeScreen()
}