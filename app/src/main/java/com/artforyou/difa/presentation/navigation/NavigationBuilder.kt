package com.artforyou.difa.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.artforyou.difa.presentation.screen.home.HomeScreen
import com.artforyou.difa.presentation.screen.about.AboutScreen
import com.artforyou.difa.presentation.screen.about.PolicyScreen
import com.artforyou.difa.presentation.screen.article.ArticleScreen
import com.artforyou.difa.presentation.screen.detection.SibiDetectionScreen
import com.artforyou.difa.presentation.screen.help.HelpScreen
import com.artforyou.difa.presentation.screen.help.ReportScreen
import com.artforyou.difa.presentation.screen.onboarding.GetStartedScreen
import com.artforyou.difa.presentation.screen.onboarding.OnBoardingScreen
import com.artforyou.difa.presentation.screen.recommendation.RecommendationScreen
import com.artforyou.difa.presentation.screen.splashscreen.SplashScreen

@Composable
fun NavigationBuilder(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = SubGraph.Splash,
        enterTransition = { fadeIn(animationSpec = tween(500)) },
        exitTransition = { fadeOut(animationSpec = tween(500)) },
        popEnterTransition = { fadeIn(animationSpec = tween(500)) },
        popExitTransition = { fadeOut(animationSpec = tween(500)) }
    ) {
        // navigation for splash screen
        navigation<SubGraph.Splash>(startDestination = Dest.SplashScreen){
            composable<Dest.SplashScreen>{
                SplashScreen(
                    moveToOnboarding = {
                        navController.navigate(SubGraph.Onboarding){
                            popUpTo(SubGraph.Splash){
                                inclusive = true
                            }
                        }
                    },
                    moveToHome = {
                        navController.navigate(SubGraph.SibiDetection){
                            popUpTo(SubGraph.Splash){
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }

        // navigation for onboarding & get started
        navigation<SubGraph.Onboarding>(startDestination = Dest.OnboardingScreen){
            composable<Dest.OnboardingScreen> {
                OnBoardingScreen(
                    moveToGetStarted = {
                        navController.navigate(Dest.GetStartedScreen){
                            popUpTo(Dest.OnboardingScreen){
                                inclusive = true
                            }
                        }
                    }
                )
            }
            composable<Dest.GetStartedScreen> {
                GetStartedScreen(
                    moveToHome = {
                        navController.navigate(SubGraph.Home){
                            popUpTo(SubGraph.Onboarding){
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }

        // navigation for home route
        navigation<SubGraph.Home>(startDestination = Dest.HomeScreen){
            composable<Dest.HomeScreen> {
                HomeScreen()
            }
        }

        // navigation for sibi detection
        navigation<SubGraph.SibiDetection>(startDestination = Dest.SibiDetectionScreen) {
            composable<Dest.SibiDetectionScreen> {
                SibiDetectionScreen()
            }
        }

        // navigation for about & Policy Screen
        navigation<SubGraph.About>(startDestination = Dest.AboutScreen) {
            composable<Dest.AboutScreen> {
                AboutScreen(
                    onBackPressed = {
                        navController.navigateUp()
                    }
                )
            }

            composable<Dest.PolicyScreen> {
                PolicyScreen(
                    onBackPressed = {
                        navController.navigateUp()
                    }
                )
            }
        }

        // navigation for help screen
        navigation<SubGraph.Help>(startDestination = Dest.HelpScreen) {
            composable<Dest.HelpScreen> {
                HelpScreen()
            }

            composable<Dest.ReportScreen> {
                ReportScreen()
            }
        }

        // navigation for recommendation
        navigation<SubGraph.Recommendation>(startDestination = Dest.RecommendationScreen) {
            composable<Dest.RecommendationScreen> {
                RecommendationScreen()
            }
        }

        // navigation for article
        navigation<SubGraph.Article>(startDestination = Dest.ArticleScreen) {
            composable<Dest.ArticleScreen> {
                ArticleScreen(
                    onBackPressed = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}