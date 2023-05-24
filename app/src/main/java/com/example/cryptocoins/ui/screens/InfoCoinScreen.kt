package com.example.cryptocoins.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cryptocoins.AppViewModelProvider
import com.example.cryptocoins.R
import com.example.cryptocoins.data.CoinDescriptor
import com.example.cryptocoins.ui.viewmodels.CoinsInfoViewModel
import com.example.cryptocoins.ui.viewmodels.interfaces.CoinInfoState

@Composable
fun CoinInfo(
    modifier: Modifier = Modifier,
    coinsInfoViewModel: CoinsInfoViewModel = viewModel(
        factory = AppViewModelProvider.Factory
    ),
    id:String = "bitcoin",
    coinsGetInfo: Unit = coinsInfoViewModel.getCoinInfo(id = id),
    imageUrl:String = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579"
){
    val uiState = coinsInfoViewModel.uiState

    when(uiState){
        is CoinInfoState.Success -> {
            Info(
                coin = uiState.coinInfo,
                imageUrl = imageUrl
            )
        }
        is CoinInfoState.Error -> {
            ErrorScreen(
                onClickTryAgain = {
                    coinsInfoViewModel.getCoinInfo(id = id)
                }
            )
        }
        is CoinInfoState.Loading -> {}
    }


}

@Composable
fun Info(
    coin:CoinDescriptor,
    modifier: Modifier = Modifier,
    imageUrl:String
){
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        item{
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(enable = true)
                    .build(),
                contentDescription = "",
                modifier = Modifier.size(90.dp),
            )

            Text(
                text = stringResource(id = R.string.desription)
            )
            Text(
                text = coin.description?.descriptor.toString()
            )
        }
    }
}