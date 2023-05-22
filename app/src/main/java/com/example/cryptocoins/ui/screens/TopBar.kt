package com.example.cryptocoins.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cryptocoins.R
import com.example.cryptocoins.ui.viewmodels.CoinsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    viewModel: CoinsViewModel
){

    val colors = FilterChipDefaults.filterChipColors(
        containerColor = Color.Gray,
        labelColor = Color.Black,
        disabledContainerColor = Color.Gray,
        disabledLabelColor = Color.Cyan,
        iconColor = Color.Cyan,
        disabledLeadingIconColor = Color.Cyan,
        disabledSelectedContainerColor = Color.Cyan,
        disabledTrailingIconColor = Color.Cyan,
        selectedContainerColor = Color.Cyan,
        selectedLabelColor = Color.Black,
        selectedLeadingIconColor = Color.Cyan,
        selectedTrailingIconColor = Color.Cyan
    )
    Surface(modifier.background(Color.Black)) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.list_crypto_coins),
                modifier = Modifier.padding(top = 16.dp)
            )
            Row(
                modifier = Modifier
            ) {
                FilterChip(
                    selected = viewModel.chipState,
                    onClick = { viewModel.getCoinsList("usd") },
                    modifier = Modifier.padding(5.dp),
                    colors = colors,
                    label = { Text(text = "USD") }
                )
                FilterChip(
                    selected = !viewModel.chipState,
                    onClick = { viewModel.getCoinsList("eur") },
                    modifier = Modifier.padding(5.dp),
                    colors = colors,
                    label = { Text(text = "EUR") }
                )
            }
        }
    }
}


