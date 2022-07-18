package com.tugrulbo.mvvmnewsapp.ui.fragments.news_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.tugrulbo.mvvmnewsapp.R
import com.tugrulbo.mvvmnewsapp.databinding.NewsDetailFragmentBinding
import com.tugrulbo.mvvmnewsapp.models.Article
import com.tugrulbo.mvvmnewsapp.ui.NewsViewModel
import com.tugrulbo.mvvmnewsapp.ui.activity.MainActivity
import okhttp3.internal.wait

class NewsDetailFragment : Fragment() {

    lateinit var binding: NewsDetailFragmentBinding
    lateinit var viewModel: NewsViewModel
    private val args:NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsDetailFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        setupData()
    }

    private fun setupData(){
       val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

    }
}