package com.example.cryptocoins.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocoins.AppViewModelProvider
import com.example.cryptocoins.ui.screens.CoinInfo
import com.example.cryptocoins.ui.screens.CryptoCoinsMainScreen
import com.example.cryptocoins.ui.screens.ErrorScreen
import com.example.cryptocoins.ui.viewmodels.CoinsInfoViewModel
import com.example.cryptocoins.ui.viewmodels.CoinsViewModel

@Composable
fun CryptoCoinsApp(
    modifier:Modifier = Modifier,
    coinsViewModel: CoinsViewModel = viewModel(
        factory = AppViewModelProvider.Factory
    ),
    coinsInfoViewModel: CoinsInfoViewModel = viewModel(
        factory = AppViewModelProvider.Factory
    ),
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = navigationRoutes.CryptoList.name
    ){
        composable(route = navigationRoutes.CryptoList.name){
            CryptoCoinsMainScreen(
                coinsViewModel = coinsViewModel,
                navigateToInfo = {
                    navController.navigate(route = navigationRoutes.CoinInfo.name)
                }
            )
        }
        composable(route = navigationRoutes.CoinInfo.name){
            coinsViewModel.currentCoin.id?.let { id ->
                coinsViewModel.currentCoin.imageUrl?.let { imageUrl ->
                    coinsViewModel.currentCoin.name?.let { it1 ->
                        CoinInfo(
                            coinsInfoViewModel = coinsInfoViewModel,
                            id = id,
                            imageUrl = imageUrl,
                            name = it1,
                            navigateUp = {navController.navigateUp()}
                        )
                    }
                }
            }
        }
        composable(route = navigationRoutes.Error.name){
            ErrorScreen () {
                if (coinsViewModel.isShowingMain){
                    coinsViewModel.getCoinsList("usd")
                }else{
                    coinsViewModel.currentCoin.id?.let { it1 -> coinsInfoViewModel.getCoinInfo(it1) }
                }
            }
        }
    }
}


enum class navigationRoutes(title:String){
    CryptoList(title = "cryptoList"),
    Error(title = "error"),
    CoinInfo(title = "coinInfo")
}

@Preview
@Composable
fun CryptoCoinAppPreview(){
}