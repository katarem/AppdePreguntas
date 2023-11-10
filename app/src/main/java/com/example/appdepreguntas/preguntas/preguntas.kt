package com.example.appdepreguntas.preguntas

import android.content.Context
import android.content.res.loader.ResourcesLoader
import android.icu.text.ListFormatter
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.appdepreguntas.R
import com.google.gson.Gson
import org.json.JSONArray
import java.io.InputStreamReader
import java.util.Arrays
import kotlin.random.Random

class Pregunta(val title: String, val image: Int, val options: List<String>, val correctOption : String, var respondida : Boolean, var correcta : Boolean)


@Composable
fun loadPreguntas() : Array<Pregunta>{
    return loadJSON(LocalContext.current)
}


fun loadJSON(context: Context): Array<Pregunta> {
    val inputStream = context.resources.openRawResource(R.raw.preguntas)
    val inputStreamReader = InputStreamReader(inputStream)
    val JSON = inputStreamReader.readText()
    val gson = Gson()
    val preguntas = gson.fromJson(JSON, Array<Pregunta>::class.java);
    inputStreamReader.close()
    preguntas.shuffle()
    return preguntas
}

