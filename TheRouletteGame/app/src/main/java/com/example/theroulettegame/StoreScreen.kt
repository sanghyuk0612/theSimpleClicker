package com.example.theroulettegame

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.theroulettegame.ViewModel.MoneyViewModel
import kotlinx.coroutines.delay
import kotlin.math.ceil

@Composable
fun StoreScreen(
    viewModel: MoneyViewModel = viewModel(),
    backButtonClick: ()->Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        StoreTopBar(
            viewModel = viewModel,
            backButtonClick = backButtonClick
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Black
        )
        StoreContent(
            viewModel,
        )
    }
}

@Composable
fun StoreContent(
    viewModel: MoneyViewModel,
    modifier: Modifier = Modifier
) {
    val holdMoney by viewModel.holdMoney.collectAsState()
    val secondMoney by viewModel.secondMoney.collectAsState()
    val clickMoney by viewModel.clickMoney.collectAsState()
    val secondUpgradeCost by viewModel.secondUpgradeCost.collectAsState()
    val clickUpgradeCost by viewModel.clickUpgradeCost.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(Unit) {   // 컴포저블이 처음 실행될 때 한 번 시작
        while (true) {       // 무한 반복
            delay(1000)
            viewModel.setHoldMoney(holdMoney + secondMoney)
        }
    }
    Column (
        modifier = modifier
    ){
        val successMessage = stringResource(R.string.Purchase_Success)
        val failMessage = stringResource(R.string.Purchase_fail)
        StoreItem(
            modifier = Modifier
                .weight(1f),
            itemTitle = R.string.Upgrade_Click_Money,
            upgradeCost = clickUpgradeCost,
            nowMoney = clickMoney,
            buyButton = {
                val buyIt = holdMoney-clickUpgradeCost
                if(buyIt>=0){
                    viewModel.setHoldMoney(buyIt)
                    viewModel.setClickMoney(ceil((clickMoney+1)*1.4).toInt())
                    viewModel.setClickUpgradeMoney(ceil(clickUpgradeCost*1.8).toInt())
                    Toast.makeText(context, successMessage, Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, failMessage, Toast.LENGTH_SHORT).show()
                }

            }
        )

        StoreItem(
            modifier = Modifier
                .weight(1f),
            itemTitle = R.string.Upgrade_Second_Money,
            upgradeCost = secondUpgradeCost,
            nowMoney = secondMoney,
            buyButton = {
                val buyIt = holdMoney-secondUpgradeCost
                if(buyIt>=0){
                    viewModel.setHoldMoney(holdMoney-secondUpgradeCost)
                    viewModel.setSecondMoney(ceil((secondMoney+1) *1.2).toInt())
                    viewModel.setSecondUpgradeMoney(ceil(secondUpgradeCost*1.6).toInt())
                    Toast.makeText(context, successMessage, Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, failMessage, Toast.LENGTH_SHORT).show()
                }
            }
        )

        val message = stringResource(R.string.RandomBoxMessage)
        RandomMoneyItem(
            modifier = Modifier
                .weight(1f),
            itemTitle = R.string.Random_Money,
            range = "0 ~ 199",
            price = 100,
            buyButton = {
                val buyIt = holdMoney - 100
                if(buyIt >= 0){
                    val random = (0..199).random()
                    viewModel.setHoldMoney(buyIt + random)
                    Toast.makeText(context, message + " ${random}!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, failMessage, Toast.LENGTH_SHORT).show()
                }
            }
        )
        RandomMoneyItem(
            modifier = Modifier
                .weight(1f),
            itemTitle = R.string.Random_Money,
            price = 1000,
            range = "0 ~ 1999",
            buyButton = {
                val buyIt = holdMoney - 1000
                if(buyIt >= 0){
                    val random = (0..1999).random()
                    viewModel.setHoldMoney(buyIt + random)
                    Toast.makeText(context, message + " ${random}!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, failMessage, Toast.LENGTH_SHORT).show()
                }
            }
        )
        RandomMoneyItem(
            modifier = Modifier
                .weight(1f),
            itemTitle = R.string.Random_Money,
            range = "0 ~ 19999",
            price = 10000,
            buyButton = {
                val buyIt = holdMoney - 10000
                if(buyIt >= 0){
                    val random = (0..19999).random()
                    viewModel.setHoldMoney(buyIt + random)
                    Toast.makeText(context, message + " ${random}!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, failMessage, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}

@Composable
fun RandomMoneyItem(
    modifier: Modifier = Modifier,
    @StringRes itemTitle: Int,
    price: Int,
    range: String,
    buyButton: ()->Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(itemTitle),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end=5.dp),
                text = stringResource(R.string.Price)+ ": " + price,
                fontSize = 14.sp,
                textAlign = TextAlign.End
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end=5.dp),
                text = stringResource(R.string.Range)+ ": $range" ,
                fontSize = 14.sp,
                textAlign = TextAlign.End
            )
            Button(
                onClick = buyButton
            ){
                Text(
                    text = stringResource(R.string.Purchase)
                )
            }
        }
    }
}
@Composable
fun StoreItem(
    modifier: Modifier = Modifier,
    @StringRes itemTitle: Int,
    upgradeCost: Int,
    nowMoney: Int,
    buyButton: ()->Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(itemTitle),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end=5.dp),
                text = stringResource(R.string.Now)+ ": " + nowMoney,
                fontSize = 14.sp,
                textAlign = TextAlign.End
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end=5.dp),
                text = stringResource(R.string.After_Upgrade)+ ": " + ceil((nowMoney+1) * 1.4).toInt(),
                fontSize = 14.sp,
                textAlign = TextAlign.End
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end=5.dp),
                text = stringResource(R.string.Upgrade_Cost)+ ": "+upgradeCost,
                fontSize = 14.sp,
                textAlign = TextAlign.End
            )
            Button(
                onClick = buyButton
            ){
                Text(
                    text = stringResource(R.string.Purchase)
                )
            }
        }
    }
}

@Composable
fun StoreTopBar(
    viewModel: MoneyViewModel,
    backButtonClick: ()->Unit
){
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        val holdMoney by viewModel.holdMoney.collectAsState()

        Button(
            onClick = backButtonClick,
            modifier = Modifier
                .padding(10.dp)
        ){
            Text(
                text = stringResource(R.string.Return_Game_Screen)
            )
        }
        Box(
            modifier = Modifier
                .padding(20.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
                .align(Alignment.TopEnd)
                .padding(4.dp)
        ) {
            Text(
                text = stringResource(R.string.Hold_Money) + " ${holdMoney}₩",
                fontSize = 16.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStoreScreen() {
    StoreScreen()
}