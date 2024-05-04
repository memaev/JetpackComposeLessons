package com.example.jetpackcomposelessons

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _counterState = mutableIntStateOf(0)
    var counterState by _counterState

    fun incrementCounter() {
        _counterState.intValue++
    }
}