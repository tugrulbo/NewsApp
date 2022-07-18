package com.tugrulbo.mvvmnewsapp.ui.fragments.homepage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.tugrulbo.mvvmnewsapp.R
import com.tugrulbo.mvvmnewsapp.databinding.HomepageFragmentBinding
import com.tugrulbo.mvvmnewsapp.ui.NewsViewModel

class HomepageFragment : Fragment() {

    lateinit var binding: HomepageFragmentBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomepageFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


}