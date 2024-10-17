package com.example.bmiviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bmiviewmodel.ui.theme.BMIViewModelTheme
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
fun Bmi(bmiViewModel: BMIViewModel = viewModel()) {

    val heightInput = bmiViewModel.heightInput
    val weightInput = bmiViewModel.weightInput
    val bmi = bmiViewModel.calculateBMI()

    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 2.dp, end = 2.dp)
    ) {
        Text(
            text = stringResource(R.string.body_mass_index),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        )
        OutlinedTextField(
            value = heightInput,
            onValueChange = { bmiViewModel.changeHeightInput(it.replace(',', '.')) },
            label = { Text(text = stringResource(R.string.height)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = weightInput,
            onValueChange = { bmiViewModel.changeWeightInput(it.replace(',', '.')) },
            label = { Text(text = stringResource(R.string.weight)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Text(text = stringResource(R.string.result, "%.2f".format(bmi)))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMIViewModelTheme {
        Bmi()
    }
}
