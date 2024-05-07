package com.example.knownyc.presentation.parks

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.knownyc.commons.Either
import com.example.knownyc.commons.Event
import com.example.knownyc.commons.EventBus
import com.example.knownyc.commons.TAG
import com.example.knownyc.domain.models.Borough
import com.example.knownyc.domain.repositories.NycParksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NycParksViewModel @Inject constructor(
    private val repository: NycParksRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(NycParksUIState())
    val state = _state.asStateFlow()

    init {
        Log.d(TAG, "ViewModel init: getting parks")
    }


    fun getParks(borough : String) {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            when (val result = repository.getParks(borough = borough)) {
                is Either.Data -> {
                    Log.d(TAG, "successfully loaded parks data")
                    _state.update {
                        it.copy(
                            parks = result.value
                        )
                    }
                }
                is Either.Error -> {
                    Log.e(TAG, "Error: loading parks data")
                    _state.update {
                        it.copy(
                            error = result.error
                        )
                    }
                    EventBus.sendEvent(Event.Toast(result.error.message))
                }
            }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}