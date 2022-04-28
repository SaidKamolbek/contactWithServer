package com.example.dependencyinjection.presenter.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjection.domain.NewsRepository
import com.example.dependencyinjection.presenter.DashboardViewModel
import javax.inject.Inject

class DashboardViewModelImpl @Inject constructor(
    private val repository: NewsRepository
) : DashboardViewModel, ViewModel() {
    override val categoriesLiveData: MutableLiveData<List<String>> =
        MutableLiveData(repository.getAllCategories())

    override val openArticleLiveData: MutableLiveData<String> = MutableLiveData()


    override fun openArticleByCategory(category: String) {
        openArticleLiveData.value = category
    }
}