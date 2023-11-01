package com.example.appdepreguntas.rutas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdepreguntas.R

@Composable
fun ModeScreen(navController: NavController?){

    Box(modifier = Modifier.fillMaxSize()){
        BackgroundImage()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            modoButton(text = "Modo normal",navController,Rutas.PreguntaScreen.ruta)
            modoButton(text = "Modo examen",navController,Rutas.PreguntaScreen.ruta)
            modoButton(text = "Volver",navController,Rutas.HomeScreen.ruta)
        }
    }

}

@Composable
fun modoButton(text: String, navController: NavController?, ruta: String){
    Button(onClick = { navController?.navigate(ruta)},
        modifier = Modifier
            .size(350.dp, 100.dp)
            .padding(10.dp)) {
        Text(text = text, fontSize = 30.sp)
    }


}






@Preview(showBackground = true)
@Composable
fun ModePreview(){
    ModeScreen(navController = null)
}