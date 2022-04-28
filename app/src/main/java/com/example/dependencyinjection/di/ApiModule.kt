package com.example.dependencyinjection.di

import com.example.dependencyinjection.data.source.remote.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideNEwsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)
}