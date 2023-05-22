package com.example.cryptocoins.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptocoins.R

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    onClickTryAgain: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bitcoin),
            contentDescription = "bitcoin",
            modifier = Modifier.size(120.dp)
        )
        Text(text = stringResource(id = R.string.error))
        Text(text = stringResource(id = R.string.t_try_again))
        Button(onClick = { onClickTryAgain }) {
            Text(text = stringResource(id = R.string.try_again))
        }
    }
}


@Preview
@Composable
fun ErrorScreenPreview(){
    ErrorScreen(
        onClickTryAgain = {}
    )
}