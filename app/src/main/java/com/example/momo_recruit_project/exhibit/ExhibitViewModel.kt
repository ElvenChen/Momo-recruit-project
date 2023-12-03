package com.example.momo_recruit_project.exhibit

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.momo_recruit_project.data.Animal
import com.example.momo_recruit_project.data.Exhibit
import com.example.momo_recruit_project.data.source.MomoRepository
import com.example.momo_recruit_project.data.source.remote.MomoRemoteDataSource.getAllAnimalDetailList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExhibitViewModel @Inject constructor(private val repository: MomoRepository) :
    ViewModel() {

    var exhibit: Exhibit? = null

    private val _animalList = MutableLiveData<List<Animal>?>()

    val animalList: LiveData<List<Animal>?>
        get() = _animalList



    private val _navigateToSelectedAnimal = MutableLiveData<Animal?>()
    val navigateToSelectedAnimal: LiveData<Animal?>
        get() = _navigateToSelectedAnimal

    // handle animal clicking navigation
    val displayAnimalDetails = fun(animal: Animal) {
        _navigateToSelectedAnimal.value = animal
    }

    // handle animal clicking navigation completed
    fun displayAnimalDetailsCompleted() {
        _navigateToSelectedAnimal.value = null
    }



    // Function：直接從北市府 Open Api 撈資料，並存入 Room DB，再從 DB 中下 Query 將符合館區的動物撈出來。
    private fun updateAllAnimalDetailFromOpenApi() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getAllAnimalDetailList()

                result.result?.results?.forEach {
                    repository.insertAnimalDetail(it)
                }

                _animalList.postValue(exhibit?.let {
                    repository.getAnimalDetailListByLocation(

                        // 因為 "熱帶雨林室內館(穿山甲館)" 在館區 Api 、動物 Api 中的 "館區名稱" 值不一樣
                        // 館區 Api 是全形括號，而動物 Api 是半形括號，造成沒辦法比對 DB 欄位中的值
                        // 所以在搜 DB 的時候需要多做這一層處理

                        if(it.name == "熱帶雨林室內館（穿山甲館）"){
                            "熱帶雨林室內館(穿山甲館)"
                        } else {
                            it.name
                        }
                    )
                })

                Log.i("test", "update from remote Api and get filter animal list from db! ")
            }
        }
    }

    // Function：檢查 Room DB 中是否有存好的數據，有的話直接下 Query 將符合館區的動物撈出來；
    // Room DB 中沒有數據的話，就打 updateAllAnimalDetailFromOpenApi() ，直接從北市府 Open Api 撈資料。
    private fun checkAllAnimalDetailFromDatabase() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getAllAnimalDetailListFromDatabase()

                if (result.isNullOrEmpty()) {
                    Log.i("test", "data base has no stored result !")

                    updateAllAnimalDetailFromOpenApi()

                } else {
                    Log.i("test", "check db and update filter animal list from db!")

                    _animalList.postValue(exhibit?.let {
                        repository.getAnimalDetailListByLocation(

                            // 因為 "熱帶雨林室內館(穿山甲館)" 在館區 Api、動物 Api 中的館區名稱不一樣
                            // 館區 Api 是全形括號、動物 Api 是半形括號，造成沒辦法比對 DB
                            // 所以在搜 DB 的時候需要多做這一層比對

                            if(it.name == "熱帶雨林室內館（穿山甲館）"){
                                "熱帶雨林室內館(穿山甲館)"
                            } else {
                                it.name
                            }
                        )
                    })
                }
            }
        }
    }

    init {
        // get animal list in this exhibit
        checkAllAnimalDetailFromDatabase()
    }
}