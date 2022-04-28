package com.example.dependencyinjection.di

import com.example.dependencyinjection.domain.NewsRepository
import com.example.dependencyinjection.domain.RegisterRepository
import com.example.dependencyinjection.domain.impl.RegisterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideNewsRepository(impl: RegisterRepositoryImpl): RegisterRepository
}