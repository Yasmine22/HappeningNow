package com.example.happeningnow.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.happeningnow.R
import com.example.happeningnow.adapters.HomePagerAdapter
import com.example.happeningnow.adapters.NewsRecyclerAdapter
import com.example.happeningnow.databinding.ActivityMainBinding
import com.example.happeningnow.databinding.FragmentTopStoriesBinding
import com.example.happeningnow.models.MediaMetadata
import com.example.happeningnow.models.Multimedia
import com.example.happeningnow.models.NewsModel
import com.example.happeningnow.viewmodels.TopStoriesViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TopStoriesFragment : Fragment() {


    @Inject lateinit var adapter: NewsRecyclerAdapter
     val viewModel:TopStoriesViewModel by viewModels()
    lateinit var binding:FragmentTopStoriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTopStoriesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.adapter = adapter


        viewModel.topStories.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            adapter.addData(it)

        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            Toast.makeText(context,it,Toast.LENGTH_LONG).show()
        }

        viewModel.getTopStories()
    }
}