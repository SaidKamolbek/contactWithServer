package com.example.dependencyinjection.domain

import android.icu.text.CaseMap
import androidx.lifecycle.LiveData
import com.example.dependencyinjection.data.model.common.ArticleData
import com.example.dependencyinjection.data.model.request.RegisterUser
import com.example.dependencyinjection.data.model.request.VerifyCode
import com.example.dependencyinjection.data.model.responce.RegisterMessage
import com.example.dependencyinjection.data.model.responce.VerifyMessage

interface NewsRepository {
    /**
     * load news from network
     */
    fun loadNewsByCategory(category: String): LiveData<List<ArticleData>>

    /**
     * get static categories list
     */
    fun getAllCategories(): List<String>

    /**
     * loading
     */
    fun loadingState(): LiveData<Boolean>

    /**
     * load from cache
     */
    fun loadArticlesByCategoryFromCache(category: String): LiveData<List<ArticleData>>

    /**
     * change fav state article
     */
    fun changeStateArticle(title: String, state: Boolean)

    // for registering user
    suspend fun registerUser(user: RegisterUser): LiveData<RegisterMessage>

    // for verifying code

    suspend fun verifyCode(code: VerifyCode): LiveData<VerifyMessage>

}