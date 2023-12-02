package com.example.momo_recruit_project.exhibit

import androidx.lifecycle.ViewModel
import com.example.momo_recruit_project.data.Exhibit
import com.example.momo_recruit_project.data.source.MomoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExhibitViewModel @Inject constructor(private val repository: MomoRepository):
    ViewModel() {

    var exhibit: Exhibit? = null


}