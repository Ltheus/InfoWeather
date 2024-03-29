package br.com.fiap.appworld.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.appworld.R
import br.com.fiap.appworld.components.AppLayout
import br.com.fiap.appworld.ui.theme.BackgroundWhite
import br.com.fiap.appworld.ui.theme.DarkBlue

@Composable
fun HomeScreen(navController: NavController) {
    var cityState by remember {
        mutableStateOf("")
    }
    val inputError = stringResource(id = R.string.input_error)
    AppLayout {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(color = BackgroundWhite),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = stringResource(id = R.string.welcome),
                fontSize = 32.sp,
                fontWeight = FontWeight(700),
                color = DarkBlue
            )
            Image(
                painter = painterResource(id = R.drawable.infoweather_icon),
                contentDescription = stringResource(id = R.string.infoweather_icon),
                modifier = Modifier.size(width = 170.dp, height = 170.dp)
            )
            OutlinedTextField(
                value = cityState,
                onValueChange = { cityState = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = DarkBlue,
                    unfocusedBorderColor = DarkBlue,
                    focusedLabelColor = DarkBlue,
                    unfocusedLabelColor = DarkBlue,
                ),
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(text = stringResource(id = R.string.start_input_label))
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.input_placeholder))
                },
                keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words),
                trailingIcon = {
                    IconButton(onClick = {
                        if (cityState !== "") {
                            navController.navigate("weather/$cityState")
                        } else {
                            cityState = inputError
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = stringResource(id = R.string.arrow_icon),
                            tint = DarkBlue
                        )
                    }
                }
            )
        }
    }

}