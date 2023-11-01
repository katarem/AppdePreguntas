package com.example.appdepreguntas.rutas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdepreguntas.R

@Composable
fun HomeScreen(navController: NavController?){

    Box(modifier = Modifier.fillMaxSize()){
        BackgroundImage()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable._logolol), contentDescription = "", contentScale = ContentScale.Inside, modifier = Modifier.padding(1.dp))
            Text(text = "Vas a hacer un test de 10 preguntas para saber qué tan friki eres del lol",
                fontSize = 20.sp)
            modoButton(text = "¡Vamos allá!", navController = navController, ruta = Rutas.ModoScreen.ruta)
        }
    }








}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = null)
}