package com.artforyou.difa.presentation.screen.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artforyou.difa.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val appUseCase: AppUseCase
) : ViewModel() {

    fun setFirstInstallDone() {
        viewModelScope.launch {
            appUseCase.setUpUser(false)
        }
    }
}