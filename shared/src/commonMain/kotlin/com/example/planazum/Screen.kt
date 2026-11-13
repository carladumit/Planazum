package com.example.planazum

sealed class Screen (val route: String) {

    object Home: Screen("home")
    object MyEvents: Screen("my_events")

}