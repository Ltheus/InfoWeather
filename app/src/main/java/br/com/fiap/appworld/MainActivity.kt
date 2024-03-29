package br.com.fiap.appworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.appworld.screens.HomeScreen
import br.com.fiap.appworld.screens.WeatherScreen
import br.com.fiap.appworld.ui.theme.AppWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppWorldTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable(route = "home"){ HomeScreen(navController)}
                        composable(route = "weather/{city}"){
                            val city = it.arguments?.getString("city")
                            WeatherScreen(city!!)}
                    }
                }
            }
        }
    }
}