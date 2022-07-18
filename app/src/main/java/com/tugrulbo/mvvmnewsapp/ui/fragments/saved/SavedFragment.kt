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
import com.tugrulbo.mvvmnewsapp.ui.activity.MainActivity

class SavedFragment : Fragment() {

    private lateinit var binding: SavedFragmentBinding
    private lateinit var viewModel:NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SavedFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }


}