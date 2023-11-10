package com.example.appdepreguntas

sealed class Puntuacion(var puntos: Int, var preguntasTotales: Int){
    object puntuacionJugador: Puntuacion(0,0)
}