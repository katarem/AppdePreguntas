package com.example.appdepreguntas.rutas

import android.graphics.drawable.shapes.Shape
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdepreguntas.Navigator
import com.example.appdepreguntas.Puntuacion
import com.example.appdepreguntas.R
import com.example.appdepreguntas.preguntas.Pregunta
import com.example.appdepreguntas.preguntas.loadPreguntas

@Composable
fun PreguntaScreen(navController: NavController?, preguntas : Array<Pregunta>, modoExamen: Boolean) {
    val puntuacion = Puntuacion.puntuacionJugador
    var index by remember { mutableIntStateOf(0) }
    var mensajeRespuesta by remember { mutableStateOf("") }
    var respuesta by remember { mutableStateOf("") }
    val pregunta = preguntas[index]
    val img = R.drawable.question
    var colorRespuesta = Color.Red
    var modo = if(modoExamen) "Modo examen" else "Modo normal"
    Box(modifier = Modifier.fillMaxSize()) {
        if(modoExamen){
            BackgroundImage(id = R.drawable.wallpaperexamen,true)
            modo = "Modo examen"
        }
        else{
            BackgroundImage(id = R.drawable.mainscreen,true)
        }
        if(pregunta.respondida){
            respuesta = pregunta.correctOption
            if(pregunta.correcta){
                mensajeRespuesta = "Correcto, era:"
                colorRespuesta = Color.Green
            }
            else mensajeRespuesta = "Incorrecto, era:"
        }
    }
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = modo, fontSize = 25.sp, fontWeight = FontWeight.SemiBold, color = Color(255,0,0))
            Text(
                text = "Pregunta ${index+1} de ${preguntas.size}",
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold
            )
            Image(

                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
                painter = painterResource(id = img),
                contentDescription = "",
                contentScale = ContentScale.Crop,

            )
            Text(text = pregunta.title, fontSize = 30.sp)
            Column() {
                for (opcion in pregunta.options) {
                    Button(
                        onClick = {
                            if(!pregunta.respondida){
                                if(opcion.equals(pregunta.correctOption)){
                                    mensajeRespuesta = "RESPUESTA CORRECTA, ERA:"
                                    respuesta = pregunta.correctOption
                                    pregunta.respondida = true
                                    pregunta.correcta = true
                                    puntuacion.puntos++
                                } else {
                                    mensajeRespuesta = "RESPUESTA INCORRECTA, ERA:"
                                    respuesta = pregunta.correctOption
                                    pregunta.respondida = true
                                }
                            }
                        },
                        Modifier
                            .fillMaxWidth()
                            .padding(5.dp), shape = RectangleShape
                    ) {
                        Text(opcion, fontSize = 22.sp)
                    }
                }
                Column(
                    Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = mensajeRespuesta, fontSize = 22.sp, textAlign = TextAlign.Center,
                        fontWeight = FontWeight(500), color = colorRespuesta,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    )
                    Text(text = respuesta,
                        fontSize = 25.sp,
                        fontWeight = FontWeight(900),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    )
                    Row(
                        Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        if(!modoExamen){
                            Button(onClick = {
                                if (index > 0) {
                                    index -= 1
                                } else {
                                    index = preguntas.size-1
                                }
                                mensajeRespuesta = ""
                                respuesta = ""
                            }
                            ) {
                                Icon(painter = painterResource(id = R.drawable.back), contentDescription = "")
                            }
                        }
                        Button(onClick = { if(pregunta.respondida){
                            if(index<preguntas.size-1)index+=1
                            else index = 0
                            mensajeRespuesta = ""
                            respuesta = ""
                        } }) {
                            Icon(painter = painterResource(id = R.drawable.next), contentDescription = "")
                        }
                    }
                }
            }

            BackHandler {
                navController?.navigate(Rutas.FinalScreen.ruta)
            }
        }
}

@Preview(showBackground = true)
@Composable
fun preguntaPreview(){
    PreguntaScreen(navController = null, preguntas = loadPreguntas().copyOfRange(0,12), modoExamen = true)
}


