package com.example.dropdown.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation(listaPersonas: SnapshotStateList<Persona>) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screenA") {
        composable("screenA") { ScreenA(navController, listaPersonas) }
        composable("screenB") { ScreenB(navController, listaPersonas) }
    }
}
