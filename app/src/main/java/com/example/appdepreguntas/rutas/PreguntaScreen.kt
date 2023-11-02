package com.example.appdepreguntas.rutas

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdepreguntas.R
import com.example.appdepreguntas.preguntas.loadPreguntas

@Composable
fun PreguntaScreen(navController: NavController?){
    val pregunta = loadPreguntas()
    Box(modifier = Modifier.fillMaxSize()){
        BackgroundImage()
        Column (Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "Pregunta 10 de 10", fontSize = 45.sp, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = pregunta.image), contentDescription = "", Modifier.padding(10.dp))
            Text(text = pregunta.title, fontSize = 30.sp)
            optionBox(opciones = pregunta.options)
            actionBox()
            loadPreguntas()
        }


    }

}


@Composable
fun optionBox(opciones : List<String>){
    Column (){
            for (i in opciones) preguntaButton(text = i)
        }
}

@Composable
fun preguntaButton(text : String){
    Button(onClick = { /*TODO*/ },
        Modifier
            .fillMaxWidth()
            .padding(10.dp), shape = RectangleShape) {
        Text(text, fontSize = 22.sp)
    }
}

@Composable
fun actionBox(){
    Row (
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,){
        Button(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.back), contentDescription = "")
        }
        Button(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.next),contentDescription = "")
        }
    }
}





@Preview(showBackground = true)
@Composable
fun preguntaPreview(){
    PreguntaScreen(navController = null)
}


