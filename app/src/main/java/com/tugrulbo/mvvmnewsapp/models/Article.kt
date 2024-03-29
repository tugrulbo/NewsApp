package com.tugrulbo.mvvmnewsapp.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.tugrulbo.mvvmnewsapp.util.Constants.DATABASE_TABLE_NAME
import java.io.Serializable


@Entity(
    tableName = DATABASE_TABLE_NAME
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    @SerializedName("author")
    var author: String?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("publishedAt")
    var publishedAt: String?,
    @SerializedName("source")
    var source: Source?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("urlToImage")
    var urlToImage: String?
):Serializable {

    override fun hashCode(): Int {
        var result = id.hashCode()
        if(url.isNullOrEmpty()){
            result = 1 * result + url.hashCode()
        }
        return result
    }
}