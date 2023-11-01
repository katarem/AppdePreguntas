package com.example.appdepreguntas.rutas

sealed class Rutas (val ruta : String){

    object HomeScreen: Rutas("homescreen")
    object PreguntaScreen : Rutas("preguntascreen")

    object ModoScreen : Rutas("modoscreen")
    object FinalScreen : Rutas("finalscreen")




}