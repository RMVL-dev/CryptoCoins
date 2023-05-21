package com.example.cryptocoins.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
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

@Composable
fun CryptoCoinsApp(
    modifier:Modifier = Modifier
){
    val coinsViewModel:CoinsViewModel = viewModel(
        factory = CoinsViewModel.Factory
    )

}


@Composable
fun CoinCard(
    modifier: Modifier = Modifier,
    coin:CoinModel
){
    Card(modifier = modifier
        .fillMaxWidth()
        .height(75.dp)
    ) {
        Row(modifier = modifier) {
            
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(coin.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = coin.name,
                modifier = modifier.size(64.dp)
            )

            Column(modifier = modifier.weight(1f)) {
                coin.name?.let { Text(text = it) }
                coin.symbol?.let { Text(text = it) }
            }

            Column(modifier = modifier.weight(1f)) {
                coin.currentPrice?.let { Text(text = "$$it") }
                coin.priceChangePercentage24h?.let { Text(text = "$it%") }
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

