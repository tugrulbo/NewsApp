package com.tugrulbo.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tugrulbo.mvvmnewsapp.models.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article):Long

    @Query("SELECT * from articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)


}