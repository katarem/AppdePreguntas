package com.example.appdepreguntas

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        composable(Rutas.PreguntaScreen.ruta){
            PreguntaScreen(navController = navController, opciones = arrayOf("A","B","C","D"))
        }


    }

}