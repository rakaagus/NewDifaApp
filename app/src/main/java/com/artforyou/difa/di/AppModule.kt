package com.artforyou.difa.di

import com.artforyou.difa.domain.usecase.AppInteractor
import com.artforyou.difa.domain.usecase.AppUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideAppRepository(appInteractor: AppInteractor): AppUseCase
}