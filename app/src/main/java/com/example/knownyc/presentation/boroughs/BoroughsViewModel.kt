package com.example.knownyc.presentation.boroughs

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.knownyc.data.local.repositories.BoroughsRepositoryImpl
import com.example.knownyc.domain.repositories.BoroughsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoroughsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: BoroughsRepository
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