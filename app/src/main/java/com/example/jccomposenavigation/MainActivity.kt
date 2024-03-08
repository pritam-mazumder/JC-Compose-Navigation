package com.example.jccomposenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jccomposenavigation.ui.theme.JCComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCComposeNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    // Traditional way to navigate
                    /*
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ){
                        composable("home"){
                            HomeScreen(navController=navController)
                        }
                        composable("second"){
                            SecondScreen(navController=navController)
                        }
                        composable("last"){
                            LastScreen(navController=navController)
                        }
                    }
                     */


                    // Another way to navigate
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.rout
                    ) {

                        composable(Screen.Home.rout) {
                            HomeScreen(navController = navController)
                        }

                        composable(
                            Screen.Second.rout + "/{url}/{counter}",
                            arguments = listOf(
                                navArgument("url") { type = NavType.StringType },
                                navArgument("counter") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->

                            SecondScreen(
                                navController = navController,
                                backStackEntry = backStackEntry
                            )
                        }

                        composable(Screen.Last.rout) {
                            LastScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

