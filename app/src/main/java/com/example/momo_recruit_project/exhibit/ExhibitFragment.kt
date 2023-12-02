package com.example.momo_recruit_project.exhibit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.util.Linkify
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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



        // setting exhibit content
        binding.exhibitMemo.text = if(viewModel.exhibit?.memo == ""){
            "無休館資訊"
        } else {
            viewModel.exhibit?.memo
        }



        //observing animal list for adapter
        viewModel.animalList.observe(viewLifecycleOwner){
            Log.i("test", "observe live data from exhibit fragment: ${it?.size}")
//            adapter.submitList(it)
//            adapter.notifyDataSetChanged()
//            binding.animalExhibitProgressBar.visibility = View.GONE
        }



        // setting navigation
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.exhibitUrl.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("${viewModel.exhibit?.url}")
            startActivity(openURL)
        }



        return binding.root
    }
}