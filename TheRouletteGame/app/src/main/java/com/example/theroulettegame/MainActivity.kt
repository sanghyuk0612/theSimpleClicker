package com.example.theroulettegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.theroulettegame.ViewModel.MoneyViewModel
import com.example.theroulettegame.ui.theme.TheRouletteGameTheme


const val SPLASH_SCREEN = "splash"
const val START_SCREEN = "start"
const val GAME_SCREEN = "game"
const val STORE_SCREEN = "store"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    TheRouletteGameTheme {
        Scaffold { paddingValues ->
            val navController = rememberNavController()
            val viewModel: MoneyViewModel = viewModel()
            NavHost(
                navController = navController,
                startDestination = "splash",
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(SPLASH_SCREEN) {
                    SplashScreen(
                        moveStartScreen = {
                            navController.navigate(START_SCREEN) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
                composable(START_SCREEN) {
                    StartScreen(
                        startButtonClick = {
                            navController.navigate(GAME_SCREEN) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
                composable(GAME_SCREEN) {
                    GameScreen(
                        viewModel = viewModel,
                        storeButtonClick = {
                            navController.navigate(STORE_SCREEN) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
                composable(STORE_SCREEN) {
                    StoreScreen(
                        viewModel = viewModel,
                        backButtonClick = {
                            navController.navigate(GAME_SCREEN) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    }
}