package com.example.cryptocoins

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.cryptocoins.ui.viewmodels.CoinsInfoViewModel
import com.example.cryptocoins.ui.viewmodels.CoinsViewModel

object AppViewModelProvider{
    val Factory = viewModelFactory {
        initializer {
            CoinsViewModel(coinsRepository = cryptoCoinsApplication().container.coinsRepository)
        }

        initializer {
            CoinsInfoViewModel(coinsRepository = cryptoCoinsApplication().container.coinsRepository)
        }
    }
}

fun CreationExtras.cryptoCoinsApplication(): CoinsApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as CoinsApplication)