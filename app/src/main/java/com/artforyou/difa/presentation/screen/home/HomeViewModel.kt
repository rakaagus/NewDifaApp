package com.artforyou.difa.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artforyou.difa.data.Resource
import com.artforyou.difa.domain.model.ArticleModel
import com.artforyou.difa.domain.model.QuoteModel
import com.artforyou.difa.domain.model.RecommendationModel
import com.artforyou.difa.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   appUseCase: AppUseCase
): ViewModel() {
    val quotes: StateFlow<Resource<List<QuoteModel>>> =
        appUseCase.getListQuotes()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Resource.Loading()
            )

    val articles: StateFlow<Resource<List<ArticleModel>>> =
        appUseCase.getListArticle()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Resource.Loading()
            )

    val recommendations: StateFlow<Resource<List<RecommendationModel>>> =
        appUseCase.getListRecommendation()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Resource.Loading()
            )
}