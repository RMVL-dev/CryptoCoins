package com.example.cryptocoins.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cryptocoins.AppViewModelProvider
import com.example.cryptocoins.data.CoinModel
import com.example.cryptocoins.ui.viewmodels.CoinsViewModel
import com.example.cryptocoins.ui.viewmodels.interfaces.CoinsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoCoinsMainScreen(
    modifier:Modifier = Modifier,
    coinsViewModel: CoinsViewModel,
    navigateToInfo: () -> Unit
){
    Scaffold(
        topBar = {
            TopBar(
                viewModel = coinsViewModel
            )
        }
    )
    { it ->
        when (coinsViewModel.coinsUIState) {
            is CoinsState.Success -> {
                CoinsList(
                    coinsList = (coinsViewModel.coinsUIState as CoinsState.Success).coinsList,
                    contentPadding = it,
                    onCardClick = { coin: CoinModel ->
                        coinsViewModel.updateCurrentCoin(coin = coin)
                        coinsViewModel.onCardClicked()
                        navigateToInfo()
                    }
                )
            }

            is CoinsState.Error -> {
                ErrorScreen(
                    onClickTryAgain = { coinsViewModel.getCoinsList("usd") }
                )
            }

            is CoinsState.Loading -> {

            }
        }
    }
}


@Composable
fun CoinsList(
    modifier: Modifier = Modifier,
    coinsList: List<CoinModel>,
    contentPadding: PaddingValues,
    onCardClick: (CoinModel) -> Unit
){
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ){
        items(coinsList){
            CoinCard(
                coin = it,
                modifier = Modifier.padding(3.dp),
                onCardClick = { coin ->
                    onCardClick(coin)
                }
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinCard(
    modifier: Modifier = Modifier,
    coin:CoinModel,
    onCardClick:(CoinModel)->Unit
){
    Card(modifier = modifier
        .fillMaxWidth()
        .height(56.dp),
        onClick = {
            onCardClick(coin)
        }
    ) {
        Row(modifier = Modifier.padding(6.dp)) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(coin.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = coin.name,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 5.dp)
            )

            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                coin.name?.let { Text(
                    text = it,
                    modifier = Modifier
                ) }
                coin.symbol?.let { Text(
                    text = it,
                    modifier = Modifier
                ) }
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                coin.currentPrice?.let { Text(
                    text = "$$it",
                    modifier = Modifier
                ) }
                coin.priceChangePercentage24h?.let { Text(
                    text = "$it%",
                    modifier = Modifier
                ) }
            }
        }
    }
}


