package com.example.schoolbrary.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

// CORES DA PALETA
val VerdeClaro = Color(0xFFDAE5AB)
val Pessego = Color(0xFFE9A385)
val Rosa = Color(0xFFFA154B)
val Vinho = Color(0xFF87313F)
val Marrom = Color(0xFF604E48)

// MODELO DE UMA MATÉRIA
data class Materia(
    val id: String,
    val nome: String,
    val descricao: String,
    val professor: String,
    val dia: String
)