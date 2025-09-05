package com.example.theroulettegame

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.theroulettegame.Components.Title


@Composable
fun StartScreen(
    startButtonClick: ()->Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                Log.i("gme","게임 시작")
                startButtonClick()
            },
    ) {
        Image(
            painter = painterResource(R.drawable.titleimage),
            contentDescription = "Title",
            modifier = Modifier
                .size(400.dp)
                .padding(bottom = 50.dp)
                .align(Alignment.Center)
        )
        Title(
            Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStartScreen(){
    StartScreen()
}