package com.example.momo_recruit_project.animal

import androidx.lifecycle.ViewModel
import com.example.momo_recruit_project.data.Animal
import com.example.momo_recruit_project.data.Exhibit
import com.example.momo_recruit_project.data.source.MomoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimalViewModel @Inject constructor(private val repository: MomoRepository) :
    ViewModel() {

    var animal: Animal? = null



}