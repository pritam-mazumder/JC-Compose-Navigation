package com.example.jccomposenavigation

// Another way / Little advance and easy (they call it) way to navigate

sealed class Screen(val rout: String) {
    data object Home : Screen("home")
    data object Second : Screen("second")
    data object Last : Screen("last")
}