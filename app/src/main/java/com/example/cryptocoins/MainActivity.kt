package com.example.cryptocoins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptocoins.ui.navigation.CryptoCoinsApp
import com.example.cryptocoins.ui.screens.CoinInfo
import com.example.cryptocoins.ui.screens.CryptoCoinsMainScreen
import com.example.cryptocoins.ui.theme.CryptoCoinsTheme
import com.example.cryptocoins.ui.viewmodels.CoinsInfoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCoinsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CryptoCoinsApp()
                }
            }
        }
    }
}

