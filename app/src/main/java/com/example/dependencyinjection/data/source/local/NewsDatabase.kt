package com.example.dependencyinjection.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dependencyinjection.data.source.local.dao.NewsDao
import com.example.dependencyinjection.data.source.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao

    companion object {
        private var INSTANCE: NewsDatabase? = null
        fun init(context: Context): NewsDatabase {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            val instance = Room.databaseBuilder(context, NewsDatabase::class.java, "news.db")
                .allowMainThreadQueries()
                .build()
            INSTANCE = instance
            return instance
        }
    }
}