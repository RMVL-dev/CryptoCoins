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
import com.example.cryptocoins.data.CoinModel
import com.example.cryptocoins.ui.viewmodels.CoinsViewModel
import com.example.cryptocoins.ui.viewmodels.interfaces.CoinsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoCoinsApp(
    modifier:Modifier = Modifier
){
    val coinsViewModel:CoinsViewModel = viewModel(
        factory = CoinsViewModel.Factory
    )

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
                contentPadding = it
            )
        }
        is CoinsState.Error -> {
            ErrorScreen(
                onClickTryAgain = {coinsViewModel.getCoinsList("usd")}
            )
        }
        is CoinsState.Loading ->{

        }
    }
}

}


@Composable
fun CoinsList(
    modifier: Modifier = Modifier,
    coinsList: List<CoinModel>,
    contentPadding: PaddingValues
){
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ){
        items(coinsList){
            CoinCard(
                coin = it,
                modifier = Modifier.padding(3.dp)
            )
        }
    }
}



@Composable
fun CoinCard(
    modifier: Modifier = Modifier,
    coin:CoinModel
){
    Card(modifier = modifier
        .fillMaxWidth()
        .height(56.dp)
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

val coin = CoinModel(
    imageUrl = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579",
    name = "Bitcoin",
    symbol = "BTC",
    currentPrice = 28000.0,
    priceChangePercentage24h = -0.7,
    id = null,
    marketCap = null,
    ath = null,
    ath_date = null,
    atl = null,
    athChangePercentage = null,
    atlChangePercentage = null,
    atlDate = null,
    circulatingSupply = null,
    fullyDilutedValuation = null,
    last_updated = null,
    marketCapChange24h = null,
    marketCapChangePercentage24h = null,
    marketCapRank = null,
    maxSupply = null,
    priceChange24h = null,
    totalSupply = null,
    roi = null,
    high24h = null,
    low24h = null,
    totalVolume = null
)

@Preview
@Composable
fun cardPreview(){
    CoinCard(coin = coin)
}

