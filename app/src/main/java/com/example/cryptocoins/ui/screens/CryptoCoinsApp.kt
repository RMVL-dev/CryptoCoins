package com.example.cryptocoins.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    Card(modifier = modifier) {
        Row(modifier = modifier) {
            
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(coin.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = coin.name
            )
            
        }
    }
}