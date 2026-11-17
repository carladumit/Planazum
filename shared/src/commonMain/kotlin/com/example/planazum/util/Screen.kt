package com.example.planazum.util

sealed class Screen (val route: String) {
    object Home: Screen("home")
    object MyEvents: Screen("my_events")

    object Login: Screen("login")

    object Register: Screen("register")
    object Profile: Screen("profile")
    object CreateEvent: Screen("create_event")

}