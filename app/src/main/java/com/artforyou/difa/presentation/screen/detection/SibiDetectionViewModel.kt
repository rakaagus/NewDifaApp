package com.artforyou.difa.presentation.screen.detection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artforyou.difa.domain.model.Recognition
import dagger.hilt.android.lifecycle.HiltViewModel

class SibiDetectionViewModel: ViewModel() {
    private val _recognitionList = MutableLiveData<Recognition>()
    val recognitionList: LiveData<Recognition> = _recognitionList

    fun updateData(recognitions: Recognition){
        _recognitionList.postValue(recognitions)
    }
}