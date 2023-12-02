package com.example.momo_recruit_project.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.momo_recruit_project.R
import com.example.momo_recruit_project.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // handle binding
        val binding = FragmentHomeBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner



        // setting recyclerView adapter
        binding.animalExhibitRecyclerView.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        val adapter = HomeListAdapter(viewModel.displayExhibitDetails)
        binding.animalExhibitRecyclerView.adapter = adapter



        //observing exhibit list for adapter
        viewModel.exhibitList.observe(viewLifecycleOwner){
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            binding.animalExhibitProgressBar.visibility = View.GONE
        }



        // setting navigation
        viewModel.navigateToSelectedExhibit.observe(viewLifecycleOwner){
            it?.let {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToExhibitFragment(it
                    )
                )
                viewModel.displayExhibitDetailsCompleted()
            }
        }


        return binding.root
    }
}