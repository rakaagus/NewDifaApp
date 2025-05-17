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
import androidx.navigation.toRoute
import com.artforyou.difa.domain.model.ArticleModel
import com.artforyou.difa.presentation.screen.about.AboutScreen
import com.artforyou.difa.presentation.screen.about.PolicyScreen
import com.artforyou.difa.presentation.screen.article.ArticleScreen
import com.artforyou.difa.presentation.screen.detection.SibiDetectionScreen
import com.artforyou.difa.presentation.screen.help.HelpScreen
import com.artforyou.difa.presentation.screen.help.ReportScreen
import com.artforyou.difa.presentation.screen.home.HomeScreen
import com.artforyou.difa.presentation.screen.onboarding.GetStartedScreen
import com.artforyou.difa.presentation.screen.onboarding.OnBoardingScreen
import com.artforyou.difa.presentation.screen.recommendation.RecommendationScreen
import com.artforyou.difa.presentation.screen.splashscreen.SplashScreen
import com.artforyou.difa.utils.extension.CustomNavType
import kotlin.Int
import kotlin.String
import kotlin.reflect.typeOf


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
                        navController.navigate(SubGraph.Home){
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
                HomeScreen(
                    moveToArticle = { model ->
                        navController.navigate(Dest.ArticleScreen(
                            article = ArticleModel(
                                id = model.id,
                                title = model.title,
                                description = model.description,
                                content = model.content,
                                url = model.url,
                                urlImage = model.urlImage,
                                image = model.image,
                                author = model.author,
                                publishAt = model.publishAt,
                                createAt = model.createAt
                            )
                        ))
                    },
                    moveToDetection = {
                        navController.navigate(Dest.SibiDetectionScreen)
                    },
                    moveToPolicy = {
                        navController.navigate(Dest.PolicyScreen)
                    },
                    moveToAbout = {
                        navController.navigate(Dest.AboutScreen)
                    },
                    moveToReport = {
                        navController.navigate(Dest.ReportScreen)
                    },
                    moveToHelp = {
                        navController.navigate(Dest.HelpScreen)
                    }
                )
            }
        }

        // navigation for sibi detection
        navigation<SubGraph.SibiDetection>(startDestination = Dest.SibiDetectionScreen) {
            composable<Dest.SibiDetectionScreen> {
                SibiDetectionScreen(
                    onBackPress = {
                        navController.navigateUp()
                    }
                )
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
                HelpScreen(
                    onBackPressed = {
                        navController.navigate(SubGraph.Home) {
                            popUpTo(SubGraph.Help) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable<Dest.ReportScreen> {
                ReportScreen(
                    onBackPressed = {
                        navController.navigate(SubGraph.Home) {
                            popUpTo(SubGraph.Help) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }

        // navigation for recommendation
        navigation<SubGraph.Recommendation>(startDestination = Dest.RecommendationScreen) {
            composable<Dest.RecommendationScreen> {
                RecommendationScreen()
            }
        }

        // navigation for article
        navigation<SubGraph.Article>(startDestination = Dest.ArticleListScreen) {

            composable<Dest.ArticleListScreen> {

            }

            composable<Dest.ArticleScreen>(
                typeMap = mapOf(typeOf<ArticleModel>() to CustomNavType<ArticleModel>(
                    clazz = ArticleModel::class,
                    serializer = ArticleModel.serializer()
                ))
            ) {
                val article = it.toRoute<Dest.ArticleScreen>()
                ArticleScreen(
                    article = article,
                    onBackPressed = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}