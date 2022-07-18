package com.tugrulbo.mvvmnewsapp.ui

import androidx.lifecycle.ViewModel
import com.tugrulbo.mvvmnewsapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
):ViewModel() {
}