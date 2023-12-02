package com.example.momo_recruit_project.exhibit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.momo_recruit_project.R
import com.example.momo_recruit_project.databinding.FragmentExhibitBinding
import com.example.momo_recruit_project.databinding.FragmentHomeBinding
import com.example.momo_recruit_project.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExhibitFragment : Fragment() {

    private val viewModel: ExhibitViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // handle binding
        val binding = FragmentExhibitBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // throwing nav-arg to viewModel
        val exhibit = ExhibitFragmentArgs.fromBundle(requireArguments()).selectedExhibit
        viewModel.exhibit = exhibit


        return binding.root
    }
}