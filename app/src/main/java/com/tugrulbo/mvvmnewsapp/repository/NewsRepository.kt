package com.tugrulbo.mvvmnewsapp.repository

import com.tugrulbo.mvvmnewsapp.api.RetrofitInstance
import com.tugrulbo.mvvmnewsapp.db.ArticleDatabase
import com.tugrulbo.mvvmnewsapp.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode:String,page:Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,page)

    suspend fun searchNews(searchQuery:String,page:Int) =
        RetrofitInstance.api.searchNews(searchQuery,page)

    suspend fun upsert(article:Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun delete(article: Article) = db.getArticleDao().deleteArticle(article)
}