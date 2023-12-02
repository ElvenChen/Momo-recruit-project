package com.example.momo_recruit_project.exhibit

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.momo_recruit_project.data.Exhibit
import com.example.momo_recruit_project.data.source.MomoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExhibitViewModel @Inject constructor(private val repository: MomoRepository):
    ViewModel() {

    var exhibit: Exhibit? = null



    private fun getAllAnimalDetailList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getAllAnimalDetailList()

                Log.i("test","$result")

//                _exhibitList.postValue(result.result?.results)
            }
        }
    }

    init {
        getAllAnimalDetailList()
    }
}