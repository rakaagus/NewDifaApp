package com.artforyou.difa.presentation.screen.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artforyou.difa.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val appUseCase: AppUseCase
): ViewModel() {
    private val _isFirst = MutableStateFlow<Boolean?>(null)
    val isFirst: StateFlow<Boolean?> get() = _isFirst

    init {
        checkFirstInstall()
    }

    private fun checkFirstInstall() {
        viewModelScope.launch {
            _isFirst.value = appUseCase.isFirstInstall()
        }
    }
}