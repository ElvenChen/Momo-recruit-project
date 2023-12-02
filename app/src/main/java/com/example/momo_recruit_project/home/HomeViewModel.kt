package com.example.momo_recruit_project.home

import androidx.lifecycle.ViewModel
import com.example.momo_recruit_project.data.source.MomoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private val repository: MomoRepository):
    ViewModel() {

        init {
            repository.test()
        }

}