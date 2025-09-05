package com.example.theroulettegame.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.theroulettegame.R

@Composable
fun MoneyInfo(
    holdMoney: Int,
    secondMoney: Int,
    clickMoney: Int,
){
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            text= stringResource(R.string.Hold_Money) + " $holdMoney ₩"
        )
        Text(
            text= stringResource(R.string.Second_Money) +" $secondMoney ₩"
        )
        Text(
            text= stringResource(R.string.Click_Money) + " $clickMoney ₩"
        )
    }
}