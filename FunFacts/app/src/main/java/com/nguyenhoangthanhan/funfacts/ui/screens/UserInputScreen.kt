package com.nguyenhoangthanhan.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nguyenhoangthanhan.funfacts.R
import com.nguyenhoangthanhan.funfacts.data.UserDataUiEvents
import com.nguyenhoangthanhan.funfacts.ui.AnimalCard
import com.nguyenhoangthanhan.funfacts.ui.ButtonComponent
import com.nguyenhoangthanhan.funfacts.ui.TextComponent
import com.nguyenhoangthanhan.funfacts.ui.TextFieldComponent
import com.nguyenhoangthanhan.funfacts.ui.TopBar
import com.nguyenhoangthanhan.funfacts.ui.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
        showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Hi there \uD83D\uDE0A")

            TextComponent(
                textValue = "Let's learn about You !",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare a details page based on input provided by you!",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(
                onTextChanged = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.UserNameEntered(it)
                    )
                }
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like", textSize = 18.sp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            ) {
                AnimalCard(
                    image = R.drawable.cat,
                    selected = userInputViewModel.uiState.value.animateSelected == "Cat",
                    animalSelected = {
                        userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                    })
                AnimalCard(
                    image = R.drawable.dog,
                    selected = userInputViewModel.uiState.value.animateSelected == "Dog",
                    animalSelected = {
                        userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                    })
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToDetailsScreen = {
                        println("==========Coming here")
                        println(
                            "==========${userInputViewModel.uiState.value.nameEntered} " +
                                    "and ${userInputViewModel.uiState.value.animateSelected}"
                        )
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.animateSelected
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel()) {

    }
}