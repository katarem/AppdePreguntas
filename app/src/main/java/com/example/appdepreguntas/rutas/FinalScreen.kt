package com.example.appdepreguntas.rutas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdepreguntas.Puntuacion
import com.example.appdepreguntas.R

@Composable
fun FinalScreen(navController: NavController?){
    val puntuacion = Puntuacion.puntuacionJugador
    val rangoImagen = when{
        puntuacion.puntos==puntuacion.preguntasTotales -> R.drawable.master
        puntuacion.puntos>10 -> R.drawable.diamond
        puntuacion.puntos>8 -> R.drawable.emerald
        puntuacion.puntos>6 -> R.drawable.platinum
        puntuacion.puntos>4 -> R.drawable.gold
        puntuacion.puntos>2 -> R.drawable.silver
        else -> R.drawable.bronze
    }

    val rango = when{
        puntuacion.puntos==puntuacion.preguntasTotales -> "master"
        puntuacion.puntos>10 -> "diamante"
        puntuacion.puntos>8 -> "esmeralda"
        puntuacion.puntos>6 -> "platino"
        puntuacion.puntos>4 -> "oro"
        puntuacion.puntos>2 -> "plata"
        else -> "bronce"
    }



    Box {
        BackgroundImage(id = R.drawable.wallpaper4,true)
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "Eres un ${rango.toUpperCase()}",
                fontSize = 50.sp,
                fontWeight = FontWeight(800),
                textAlign = TextAlign.Center,
                color = Color.Yellow
            )
            Image(painter = painterResource(id = rangoImagen), contentDescription = "",
                contentScale = ContentScale.Crop, modifier = Modifier
                    .width(300.dp)
                    .height(300.dp))
            Text(text = "Has acertado ${puntuacion.puntos} de ${puntuacion.preguntasTotales} preguntas",
                fontSize = 50.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center,
                color = Color.Yellow
            )
            Button(onClick = { navController!!.popBackStack(route = Rutas.HomeScreen.ruta,inclusive = true)}) {
                Text(text = "Volver")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun FinalPreview(){
    FinalScreen(navController = null)
}