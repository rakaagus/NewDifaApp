package com.artforyou.difa.presentation.navigation

import com.artforyou.difa.domain.model.ArticleModel
import kotlinx.serialization.Serializable

sealed class SubGraph{

    @Serializable
    data object Splash: SubGraph()

    @Serializable
    data object Onboarding: SubGraph()

    @Serializable
    data object Home: SubGraph()

    @Serializable
    data object SibiDetection: SubGraph()

    @Serializable
    data object About: SubGraph()

    @Serializable
    data object Help: SubGraph()

    @Serializable
    data object Recommendation: SubGraph()

    @Serializable
    data object Article: SubGraph()
}

sealed class Dest {
    @Serializable
    data object SplashScreen: Dest()

    @Serializable
    data object OnboardingScreen: Dest()

    @Serializable
    data object GetStartedScreen: Dest()

    @Serializable
    data object HomeScreen: Dest()

    @Serializable
    data object SibiDetectionScreen: Dest()

    @Serializable
    data object PolicyScreen: Dest()

    @Serializable
    data object AboutScreen: Dest()

    @Serializable
    data object HelpScreen: Dest()

    @Serializable
    data object ReportScreen: Dest()

    @Serializable
    data object RecommendationScreen: Dest()

    @Serializable
    data object ArticleListScreen: Dest()

    @Serializable
    data class ArticleScreen(
        val article: ArticleModel
    ): Dest()
}