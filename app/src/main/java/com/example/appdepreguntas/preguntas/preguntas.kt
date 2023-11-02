package com.example.appdepreguntas.preguntas

import android.content.Context
import android.content.res.loader.ResourcesLoader
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.appdepreguntas.R
import com.google.gson.Gson
import org.json.JSONArray
import java.io.InputStreamReader

data class Pregunta(val title: String, val image: Int,val options: List<String>)


@Composable
fun loadPreguntas() : Pregunta{
    return loadJSON(LocalContext.current)
}

fun loadJSON(context: Context): Pregunta {
    val inputStream = context.resources.openRawResource(R.raw.preguntas)
    val inputStreamReader = InputStreamReader(inputStream)
    val JSON = inputStreamReader.readText()
    val gson = Gson()
    val preguntas = gson.fromJson(JSON,Array<Pregunta>::class.java);
    inputStreamReader.close()
    return preguntas.get(0)
}



