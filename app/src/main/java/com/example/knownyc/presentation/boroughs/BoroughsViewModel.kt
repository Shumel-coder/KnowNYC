package com.example.knownyc.presentation.boroughs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class BoroughsViewModel constructor(

) : ViewModel(){
    private val _state = MutableStateFlow(BoroughsUIState())
    val state = _state.asStateFlow()

    init {
        getBoroughs()
    }

    private fun getBoroughs() {
        viewModelScope.launch {

        }
    }
}