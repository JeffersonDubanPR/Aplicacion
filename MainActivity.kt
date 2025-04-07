package com.example.dropdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf

import com.example.dropdown.nav.Navigation
import com.example.dropdown.nav.Persona
import com.example.dropdown.ui.theme.DropdownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listaPersonas = mutableStateListOf<Persona>()

        setContent {
            DropdownTheme {
                Navigation(listaPersonas)
            }
        }
    }
}











