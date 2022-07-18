package com.tugrulbo.mvvmnewsapp.db

import android.content.Context
import androidx.room.*
import com.tugrulbo.mvvmnewsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class ArticleDatabase:RoomDatabase() {

    abstract fun getArticleDao():ArticleDAO

    companion object{
        @Volatile
        private var instance:ArticleDatabase?=null
        private var LOCK = Any()

        operator fun invoke(context:Context)= instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}