package com.example.appdepreguntas

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appdepreguntas.preguntas.loadPreguntas
import com.example.appdepreguntas.rutas.FinalScreen
import com.example.appdepreguntas.rutas.HomeScreen
import com.example.appdepreguntas.rutas.ModeScreen
import com.example.appdepreguntas.rutas.PreguntaScreen
import com.example.appdepreguntas.rutas.Rutas

@Composable
fun Navigator(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.HomeScreen.ruta){
        composable(Rutas.HomeScreen.ruta){
            HomeScreen(navController = navController)
        }
        composable(Rutas.ModoScreen.ruta){
            ModeScreen(navController = navController)
        }
        composable(Rutas.PreguntaScreen.ruta + "/{modoExamen}"){
            llamada ->
            val puntuacion = Puntuacion.puntuacionJugador
            val modoExamen = llamada.arguments!!.getString("modoExamen","false").toBoolean()
            val preguntas = if(modoExamen)loadPreguntas().copyOfRange(0,12) else loadPreguntas()
            puntuacion.preguntasTotales = preguntas.size
           PreguntaScreen(navController = navController, preguntas, modoExamen = modoExamen)
        }
        composable(Rutas.FinalScreen.ruta){
            FinalScreen(navController = navController)
        }



    }

}