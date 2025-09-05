package com.example.theroulettegame

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    moveStartScreen: ()->Unit = {}
) {
    LaunchedEffect(Unit) {
        delay(2000) // 2초 대기
        moveStartScreen()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.outline_videogame_asset_24),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )
        Text(
            text = stringResource(R.string.app_logo_name),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 120.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen(){
    val navController = rememberNavController()
    SplashScreen()
}