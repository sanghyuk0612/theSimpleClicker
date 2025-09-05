package com.example.theroulettegame.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.theroulettegame.R

@Composable
fun Title(
    modifier : Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row{
            Image(
                painter = painterResource(R.drawable.attach_money_24dp_e3e3e3),
                contentDescription = "Title",
                modifier = Modifier.size(70.dp)
            )
            Image(
                painter = painterResource(R.drawable.attach_money_24dp_e3e3e3),
                contentDescription = "Title",
                modifier = Modifier.size(70.dp)
            )
            Image(
                painter = painterResource(R.drawable.attach_money_24dp_e3e3e3),
                contentDescription = "Title",
                modifier = Modifier.size(70.dp)
            )
        }
        Text(
            text = "To be Rich",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp)
        )
        Text(
            text = "Touch The Screen",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 30.dp)
        )
    }
}