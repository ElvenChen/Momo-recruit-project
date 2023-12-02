package com.example.momo_recruit_project.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.momo_recruit_project.data.Exhibit
import com.example.momo_recruit_project.data.source.MomoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class HomeViewModel  @Inject constructor(private val repository: MomoRepository):
    ViewModel() {

    private val _exhibitList = MutableLiveData<List<Exhibit>?>()

    val exhibitList: LiveData<List<Exhibit>?>
        get() = _exhibitList




    private fun getAnimalExhibitList(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repository.getAnimalExhibitList()
            }
        }
    }

        init {
            repository.test()

            getAnimalExhibitList()
        }

}