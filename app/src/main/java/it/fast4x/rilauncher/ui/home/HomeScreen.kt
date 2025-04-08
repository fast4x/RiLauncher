package it.fast4x.rilauncher.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import it.fast4x.rilauncher.R
import it.fast4x.rilauncher.typography

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Text(
            text = stringResource(id = R.string.app_name),
            fontStyle = typography().xxxl.fontStyle,
            fontSize = typography().xxxl.fontSize,
            fontWeight = typography().xxxl.fontWeight,
            fontFamily = typography().xxxl.fontFamily,
            letterSpacing = typography().xxxl.letterSpacing,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )

    }
}