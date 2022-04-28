package com.example.dependencyinjection.di

import android.content.Context
import com.example.dependencyinjection.data.source.local.NewsDatabase
import com.example.dependencyinjection.data.source.local.dao.NewsDao
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

class DatabaseModule {

//    @Provides
//    fun provideNewsDatabase(@ApplicationContext context: Context): NewsDatabase =
//        NewsDatabase.init(context)
//
//    @Provides
//    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao = newsDatabase.getNewsDao()


}