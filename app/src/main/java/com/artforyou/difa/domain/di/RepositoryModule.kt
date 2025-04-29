package com.artforyou.difa.domain.di

import com.artforyou.difa.data.repository.AppRepository
import com.artforyou.difa.domain.repository.IAppRepository
import dagger.Binds
import dagger.Module


@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideAppRepository(appRepository: AppRepository): IAppRepository
}