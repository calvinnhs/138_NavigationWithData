package com.example.navdata

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanFrom(
    onSubmitButtonClicked: (MutableList<String>) -> Unit
) {
    var namaTxt by remember { mutableStateOf("") }
    var alamatTxt by remember { mutableStateOf("") }
    var tlpnTxt by remember { mutableStateOf("") }

    var listData: MutableList<String> = mutableListOf(namaTxt, alamatTxt, tlpnTxt)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(value = namaTxt, onValueChange = { namaTxt = it }, label = {
            Text(text = stringResource(id = R.string.namap))
        })
    }
}