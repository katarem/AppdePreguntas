package com.example.appdepreguntas.rutas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appdepreguntas.R

@Composable
fun BackgroundImage(id: Int, blur: Boolean){

    val modifier = if(!blur) Modifier.fillMaxSize() else Modifier.fillMaxSize().blur(
        radiusX = 10.dp,
        radiusY = 10.dp,
        edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
    )

    Image(painter = painterResource(id = id),
        contentDescription = "", modifier = modifier,
        contentScale = ContentScale.Crop)
}