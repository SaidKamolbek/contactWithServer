package com.example.dependencyinjection.presenter

import androidx.lifecycle.LiveData
import com.example.dependencyinjection.data.model.common.ArticleData

interface ArticleViewModel {
    val loadingLiveData: LiveData<Boolean>
    val backLiveData: LiveData<Unit>
    val articlesLiveData: LiveData<List<ArticleData>>

    fun back()

    fun loadArticlesByCategory(category: String)

    fun changeFavArticle(title: String, state: Boolean)

}