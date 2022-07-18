package com.tugrulbo.mvvmnewsapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tugrulbo.mvvmnewsapp.databinding.ActivityMainBinding
import com.tugrulbo.mvvmnewsapp.db.ArticleDatabase
import com.tugrulbo.mvvmnewsapp.repository.NewsRepository
import com.tugrulbo.mvvmnewsapp.ui.NewsViewModel
import com.tugrulbo.mvvmnewsapp.ui.NewsViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  repository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelFactory(newsRepository = repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
    }
}