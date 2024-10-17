package com.example.bmiviewmodel.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class BMIViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    fun changeHeightInput(value: String) {
        heightInput = value
    }

    fun changeWeightInput(value: String) {
        weightInput = value
    }

    fun calculateBMI(): Float {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toFloatOrNull() ?: 0.0f
        return if (height > 0 && weight > 0) weight / (height * height) else 0.0f
    }

}

