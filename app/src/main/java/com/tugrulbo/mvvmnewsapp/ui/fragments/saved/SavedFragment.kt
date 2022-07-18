package com.tugrulbo.mvvmnewsapp.ui.fragments.saved

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tugrulbo.mvvmnewsapp.R
import com.tugrulbo.mvvmnewsapp.databinding.SavedFragmentBinding
import com.tugrulbo.mvvmnewsapp.ui.NewsViewModel

class SavedFragment : Fragment() {

    private lateinit var binding: SavedFragmentBinding
    private val viewModel:NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SavedFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


}