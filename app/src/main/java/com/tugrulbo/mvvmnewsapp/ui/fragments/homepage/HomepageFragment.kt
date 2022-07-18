package com.tugrulbo.mvvmnewsapp.ui.fragments.homepage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tugrulbo.mvvmnewsapp.adapters.NewsAdapter
import com.tugrulbo.mvvmnewsapp.databinding.HomepageFragmentBinding
import com.tugrulbo.mvvmnewsapp.ui.NewsViewModel
import com.tugrulbo.mvvmnewsapp.ui.activity.MainActivity
import com.tugrulbo.mvvmnewsapp.util.Resource
import com.tugrulbo.mvvmnewsapp.util.extensions.isVisible

class HomepageFragment : Fragment() {

    lateinit var binding: HomepageFragmentBinding
    lateinit var newsAdapter: NewsAdapter
    lateinit var viewModel: NewsViewModel

    private val TAG = "BreakingNewsFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomepageFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()
    }
    private fun setupRecyclerView(){
        newsAdapter = NewsAdapter()
        binding.rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        }

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response->
            when(response){
                is Resource.Success-> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message->
                        Log.e(TAG,message)
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar(){
        binding.paginationProgressBar.visibility = View.GONE
    }

    private fun showProgressBar(){
        binding.paginationProgressBar.visibility = View.VISIBLE
    }


}