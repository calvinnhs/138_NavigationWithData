package com.example.navdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.navdata.Data.OrderUIState
import com.example.navdata.ui.theme.NavDataTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat


private const val HARGA_PER_CUP = 3000

class OrderViewModel : ViewModel() {
    private val  _stateUI = MutableStateFlow(OrderUIState())
    val statsUI : StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlEsJumbo:Int){
        _stateUI.update { stateSaatini ->
            stateSaatini.copy(
                jumlah = jmlEsJumbo,
                harga = hitungharga(jumlah = jmlEsJumbo)
            )
        }
    }
    fun setRasa(rasaPilihan : String){
        _stateUI.update { stateSaatini ->
            stateSaatini.copy(rasa = rasaPilihan)
        }
    }
    fun resetOrder(){
        _stateUI.value = OrderUIState()

    }

    private fun hitungharga(
        jumlah: Int = _stateUI.value.jumlah,
    ): String{
        val kalkulasHarga = jumlah * HARGA_PER_CUP
        return NumberFormat.getNumberInstance().format(kalkulasHarga)
    }

    fun setContact(list: MutableList<String>){
        _stateUI.update { stateSaatini ->
            stateSaatini.copy(
                nama = list[0],
                alamat = list[1],
                tlp = list[2],
            )
        }
    }
}