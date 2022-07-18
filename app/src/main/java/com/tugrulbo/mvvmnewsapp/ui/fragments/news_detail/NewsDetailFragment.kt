package com.tugrulbo.mvvmnewsapp.ui.fragments.news_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tugrulbo.mvvmnewsapp.R
import com.tugrulbo.mvvmnewsapp.databinding.NewsDetailFragmentBinding
import com.tugrulbo.mvvmnewsapp.ui.NewsViewModel

class NewsDetailFragment : Fragment() {

    lateinit var binding: NewsDetailFragmentBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsDetailFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

}