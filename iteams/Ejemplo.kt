package com.example.dropdown.iteams
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext

import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu

import androidx.compose.material3.Text



@Composable
fun lista() {
    val context = LocalContext.current
    var selectedColor by remember { mutableStateOf(Color.Black) }
    var selectedFontSize by remember { mutableStateOf(16.sp) }
    var selectedFontWeight by remember { mutableStateOf(FontWeight.Normal) }

    val colors = listOf("Negro", "Rojo", "Azul", "Verde", "Amarrillo")
    val fontWeights = listOf("Normal", "Negrita", "Ligero", "Medio", "Extra Negrita")

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Opciones", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(10.dp))

        SimpleDropdown("Color", colors) { selectedColor = when (it) {
            "Negro" -> Color.Black
            "Rojo" -> Color.Red
            "Azul" -> Color.Blue
            "Verde" -> Color.Green
            "Amarillo" -> Color.Yellow
            else -> Color.Black
        }}



        SimpleDropdown("Estilo", fontWeights) { selectedFontWeight = when (it) {
            "Normal" -> FontWeight.Normal
            "Negrita" -> FontWeight.Bold
            "Ligero" -> FontWeight.Light
            "Medio" -> FontWeight.Medium
            "Extra Negrita" -> FontWeight.ExtraBold
            else -> FontWeight.Normal
        }}

        Spacer(modifier = Modifier.height(20.dp))

        Text("Hola", color = selectedColor, fontSize = selectedFontSize, fontWeight = selectedFontWeight)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            Toast.makeText(context, "Cambios Aplicados", Toast.LENGTH_SHORT).show()
        }) {
            Text("Aplicar")
        }
    }
}

@Composable
fun SimpleDropdown(label: String, options: List<String>, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options.first()) }


    Column {
        Text(label)
        Button(onClick = { expanded = !expanded }) {
            Text(selectedOption)
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                        onSelect(option)
                    }
                )
            }
        }
    }
}
