package com.example.happeningnow.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.happeningnow.adapters.NewsRecyclerAdapter
import com.example.happeningnow.databinding.FragmentMostViewedBinding
import com.example.happeningnow.viewmodels.MostViewedViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MostViewedFragment : Fragment() {


    @Inject
    lateinit var adapter: NewsRecyclerAdapter
    val viewModel: MostViewedViewModel by viewModels()
    private lateinit var binding: FragmentMostViewedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMostViewedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        binding.recyclerView.adapter = adapter


        viewModel.mostViewedNews.observe(viewLifecycleOwner) {

            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            adapter.addData(it)

        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }

        viewModel.getMostViewed()


    }
}