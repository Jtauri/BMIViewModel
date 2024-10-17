package com.example.bmiviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bmiviewmodel.ui.theme.BMIViewModelTheme
import com.example.bmiviewmodel.R
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.bmiviewmodel.ui.viewmodel.BMIViewModel
import androidx.lifecycle.viewmodel.compose.viewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMIViewModelTheme {
                Bmi()
            }
        }
    }
}

@Composable
fun Bmi(BMIViewModel: BMIViewModel = viewModel()) {

    val heightInput = BMIViewModel.heightInput
    val weightInput = BMIViewModel.weightInput
    val bmi = BMIViewModel.calculateBMI()


    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 2.dp, end = 2.dp)
    ) {
        Text(
            text = stringResource(R.string.body_mass_index),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = heightInput,
            onValueChange = { BMIViewModel.changeHeightInput(it.replace(',', '.')) },
            label = { Text(text = stringResource(R.string.height)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = weightInput,
            onValueChange = { BMIViewModel.changeWeightInput(it.replace(',', '.')) },
            label = { Text(text = stringResource(R.string.weight)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Text(text = stringResource(R.string.result, String.format("%.2f", bmi)))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMIViewModelTheme {
        Bmi()
    }
}
