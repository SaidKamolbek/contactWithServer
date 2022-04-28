package com.example.dependencyinjection.presenter.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjection.data.model.common.ArticleData
import com.example.dependencyinjection.domain.NewsRepository
import com.example.dependencyinjection.presenter.ArticleViewModel
import uz.xsoft.newsappdi.utils.AppConnectionUtil
import javax.inject.Inject

class ArticleViewModelImpl @Inject constructor(
    private val repository: NewsRepository,
    private val connectionUtil: AppConnectionUtil
) : ArticleViewModel, ViewModel() {

    override val loadingLiveData: LiveData<Boolean> = repository.loadingState()

    override val backLiveData: MutableLiveData<Unit> = MutableLiveData()

    override var articlesLiveData: LiveData<List<ArticleData>> = MutableLiveData()

    override fun back() {
        backLiveData.value = Unit
    }

    override fun loadArticlesByCategory(category: String) {
        articlesLiveData =
            if (connectionUtil.isConnected()) repository.loadNewsByCategory(category)
            else repository.loadArticlesByCategoryFromCache(category)
    }

    override fun changeFavArticle(title: String, state: Boolean) {
        repository.changeStateArticle(title, state)
    }
}