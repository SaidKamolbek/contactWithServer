package com.example.dependencyinjection.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.dependencyinjection.data.model.common.ArticleData
import com.example.dependencyinjection.data.source.local.entity.ArticleEntity

@Dao
interface NewsDao : BaseDao<ArticleEntity> {

    @Query("SELECT * FROM ArticleEntity  WHERE category = :category")
    fun getNewsByCategory(category: String): LiveData<List<ArticleData>>


    @Query("UPDATE  ArticleEntity SET isFav= :favState WHERE title= :title")
    fun updateFav(title: String, favState: Boolean)
}