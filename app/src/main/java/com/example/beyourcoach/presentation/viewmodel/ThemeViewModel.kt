package com.example.beyourcoach.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.beyourcoach.domain.model.UserMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor() : ViewModel() {
    private val _mode = MutableStateFlow(UserMode.LITE)
    val mode: StateFlow<UserMode> = _mode.asStateFlow()

    fun toggleMode() {
        _mode.value = if (_mode.value == UserMode.LITE) UserMode.PRO else UserMode.LITE
    }
}
