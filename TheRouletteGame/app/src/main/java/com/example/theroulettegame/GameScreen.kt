package com.example.theroulettegame

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.theroulettegame.Components.MoneyInfo
import com.example.theroulettegame.ViewModel.MoneyViewModel
import kotlinx.coroutines.delay

@Composable
fun GameScreen(
    viewModel: MoneyViewModel = viewModel(),
    storeButtonClick: ()->Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val holdMoney by viewModel.holdMoney.collectAsState()
        val secondMoney by viewModel.secondMoney.collectAsState()
        val clickMoney by viewModel.clickMoney.collectAsState()
        var showImage by remember { mutableStateOf(false) }

        AnimatedVisibility(
            visible = showImage,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut(),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 150.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.attach_money_24dp_e3e3e3),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
        LaunchedEffect(showImage) {
            if (showImage) {
                delay(300)
                showImage = false
            }
        }
        LaunchedEffect(Unit) {   // 컴포저블이 처음 실행될 때 한 번 시작
            while (true) {       // 무한 반복
                delay(1000)
                viewModel.setHoldMoney(holdMoney+secondMoney)
                showImage = false
            }
        }
        MoneyInfo(
            holdMoney = holdMoney,
            secondMoney = secondMoney,
            clickMoney = clickMoney
        )

        Button(
            onClick = storeButtonClick,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
        ){
            Text(
                text = stringResource(R.string.Store_Button)
            )
        }

        Image(
            painter = painterResource(R.drawable.gold_sticker),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.Center)
                .clickable {
                    showImage = true
                    viewModel.setHoldMoney(holdMoney + clickMoney)
                }
        )
        Text(
            text = stringResource(R.string.Game_Screen_Explain),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 120.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun TempImageDisplay(showImage: Boolean) {
    // 이미지 (애니메이션과 함께 조건부 표시)

}


@Preview(showBackground = true)
@Composable
fun PreviewGameScreen() {
    GameScreen()
}