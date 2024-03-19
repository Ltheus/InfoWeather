package br.com.fiap.appworld.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.appworld.R
import br.com.fiap.appworld.components.AppLayout
import br.com.fiap.appworld.ui.theme.BackgroundWhite
import br.com.fiap.appworld.ui.theme.DarkBlue
import br.com.fiap.appworld.ui.theme.TextBlack
import br.com.fiap.appworld.ui.theme.Yellow

@Composable
fun WeatherScreen() {
    AppLayout() {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp, vertical = 10.dp)
                .background(color = BackgroundWhite),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                text = stringResource(id = R.string.home_title_key),
                fontSize = 28.sp,
                fontWeight = FontWeight(700),
                color = DarkBlue
            )
            Image(
                painter = painterResource(id = R.drawable.sun_icon),
                contentDescription = stringResource(id = R.string.weather_icon),
                modifier = Modifier.size(width = 170.dp, height = 170.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = "34 Cº",
                    fontSize = 28.sp,
                    fontWeight = FontWeight(700),
                    color = DarkBlue
                )
                Text(
                    text = "Min: 26 Cº | Max: 34 Cº",
                    fontSize = 28.sp,
                    fontWeight = FontWeight(400),
                    color = TextBlack
                )
                Text(
                    text = "${stringResource(id = R.string.feelslike_key)} 34 Cº",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(400),
                    color = TextBlack
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
//                    .background(color = Yellow),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.droplet_icon),
                        contentDescription = stringResource(id = R.string.droplet_icon),
                        modifier = Modifier.size(width = 18.dp, height = 18.dp)
                    )
                    Text(
                        text = ": 63%",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        color = TextBlack
                    )
                }
            }
            OutlinedTextField(
                value = "",
                onValueChange = {},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = DarkBlue,
                    unfocusedBorderColor = DarkBlue,
                    focusedLabelColor = DarkBlue,
                    unfocusedLabelColor = DarkBlue,
                ),
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(text = stringResource(id = R.string.search_input_label))
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.input_placeholder))
                },
                keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words),
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(id = R.string.search_icon),
                            tint = DarkBlue
                        )
                    }
                }
            )
        }
    }

}