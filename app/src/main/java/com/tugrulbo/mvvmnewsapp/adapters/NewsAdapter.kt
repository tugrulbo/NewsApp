package com.tugrulbo.mvvmnewsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tugrulbo.mvvmnewsapp.R
import com.tugrulbo.mvvmnewsapp.models.Article

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    private val differCallback = object :DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var article = differ.currentList[position]
        holder.itemView.apply {
            val ivNewsImage:ImageView = this.findViewById(R.id.ivArticleImage)
            val tvSource:TextView = this.findViewById(R.id.tvSource)
            val tvTitle:TextView = this.findViewById(R.id.tvTitle)
            val tvDesc:TextView = this.findViewById(R.id.tvDescription)
            val tvPublishedAt:TextView = this.findViewById(R.id.tvPublishedAt)

            Glide.with(this).load(article.urlToImage).into(ivNewsImage)
            tvSource.text = article.source.name
            tvTitle.text = article.title
            tvDesc.text = article.description
            tvPublishedAt.text = article.publishedAt

            setOnClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener:((Article)->Unit)?=null

    fun setOnItemClickListener(listener:(Article)->Unit){
        onItemClickListener = listener
    }


}