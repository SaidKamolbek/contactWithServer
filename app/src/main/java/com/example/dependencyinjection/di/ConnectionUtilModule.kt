package com.example.dependencyinjection.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.xsoft.newsappdi.utils.AppConnectionUtil
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ConnectionUtilModule {

    @[Provides Singleton]
    fun provideConnectionUtil(@ApplicationContext context: Context) = AppConnectionUtil(context)
}