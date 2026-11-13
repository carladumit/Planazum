package com.example.planazum


import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planazum.screens.HomeScreen
import com.example.planazum.screens.MyEventsScreen
import com.example.planazum.util.Screen


@Composable
@Preview (showBackground = true)
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(
                navController = navController
            )
                }


        composable(route = Screen.MyEvents.route){
            MyEventsScreen(navController = navController)
        }




    }

}

