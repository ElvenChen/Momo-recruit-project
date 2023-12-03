package com.example.momo_recruit_project.animal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.momo_recruit_project.R
import com.example.momo_recruit_project.databinding.FragmentAnimalBinding
import com.example.momo_recruit_project.databinding.FragmentExhibitBinding
import com.example.momo_recruit_project.exhibit.ExhibitFragmentArgs
import com.example.momo_recruit_project.exhibit.ExhibitViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnimalFragment : Fragment() {

    private val viewModel: AnimalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // handle binding
        val binding = FragmentAnimalBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner



        // throwing nav-arg to viewModel
        val animal = AnimalFragmentArgs.fromBundle(requireArguments()).selectedAnimal
        viewModel.animal = animal



        // setting navigation
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }



        return binding.root
    }
}