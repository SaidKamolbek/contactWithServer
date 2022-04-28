package com.example.dependencyinjection.domain.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dependencyinjection.data.model.common.ArticleData
import com.example.dependencyinjection.data.model.responce.BaseResponse
import com.example.dependencyinjection.data.model.responce.toEntity
import com.example.dependencyinjection.data.source.local.Categories
import com.example.dependencyinjection.data.source.local.dao.NewsDao
import com.example.dependencyinjection.data.source.remote.NewsApi
import com.example.dependencyinjection.domain.NewsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
//
//class NewsRepositoryImpl @Inject constructor(
//    private val newsDao: NewsDao,
//    private val newApi: NewsApi
//) : NewsRepository {
//    private val loadingLiveData = MutableLiveData(false)
//
//    override fun loadNewsByCategory(category: String): LiveData<List<ArticleData>> {
//        loadingLiveData.value = true
//        newApi.getNewsByCategory(category).enqueue(object : Callback<BaseResponse> {
//            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
//                loadingLiveData.value = false
//                if (response.isSuccessful && response.body() != null) {
//                    val result = response.body()?.data ?: arrayListOf()
//                    newsDao.insertAll(result.map { it.toEntity(category) })
//                }
//            }
//
//            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
//                loadingLiveData.value = false
//            }
//        })
//
//        return newsDao.getNewsByCategory(category)
//    }
//
//    override fun getAllCategories(): List<String> = Categories.getAllCategory()
//
//    override fun loadingState(): LiveData<Boolean> = loadingLiveData
//
//    override fun loadArticlesByCategoryFromCache(category: String): LiveData<List<ArticleData>> {
//        return newsDao.getNewsByCategory(category)
//    }
//
//    override fun changeStateArticle(title: String, state: Boolean) {
//        newsDao.updateFav(title, state)
//    }
//
//}