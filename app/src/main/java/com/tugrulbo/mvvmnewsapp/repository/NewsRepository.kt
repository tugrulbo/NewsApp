package com.tugrulbo.mvvmnewsapp.repository

import com.tugrulbo.mvvmnewsapp.api.RetrofitInstance
import com.tugrulbo.mvvmnewsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode:String,page:Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,page)

    suspend fun searchNews(searchQuery:String,page:Int) =
        RetrofitInstance.api.searchNews(searchQuery,page)
}