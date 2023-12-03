package com.example.momo_recruit_project.animal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _animalLatinName = MutableLiveData<String?>()
    val animalLatinName: LiveData<String?>
        get() = _animalLatinName

    private val _animalAlsoKnown = MutableLiveData<String?>()
    val animalAlsoKnown: LiveData<String?>
        get() = _animalAlsoKnown

    private val _animalFeature = MutableLiveData<String?>()
    val animalFeature: LiveData<String?>
        get() = _animalFeature

    private val _animalBehavior = MutableLiveData<String?>()
    val animalBehavior: LiveData<String?>
        get() = _animalBehavior

    private val _animalDiet = MutableLiveData<String?>()
    val animalDiet: LiveData<String?>
        get() = _animalDiet

    private val _animalDistribution = MutableLiveData<String?>()
    val animalDistribution: LiveData<String?>
        get() = _animalDistribution

    private val _animalHabitat = MutableLiveData<String?>()
    val animalHabitat: LiveData<String?>
        get() = _animalHabitat

    private val _animalLastUpdateTime = MutableLiveData<String?>()
    val animalLastUpdateTime: LiveData<String?>
        get() = _animalLastUpdateTime




    fun reorganizeAnimalData(){
        _animalLatinName.value = if (animal?.latinName == "") {
            "本物種尚無相關學名"
        } else {
            animal?.latinName
        }

        _animalAlsoKnown.value = if (animal?.alsoknown == "") {
            "本物種無相關別稱"
        } else {
            animal?.alsoknown
        }

        _animalFeature.value = if (animal?.feature == "") {
            "本物種尚無簡介"
        } else {
            animal?.feature
        }

        _animalBehavior.value = if (animal?.behavior == "") {
            "本物種尚無特性描述"
        } else {
            animal?.behavior
        }

        _animalDiet.value = if (animal?.diet == "") {
            "本物種尚無食性描述"
        } else {
            animal?.diet
        }

        _animalDistribution.value = if (animal?.distribution == "") {
            "本物種尚無世界分布描述"
        } else {
            animal?.distribution
        }

        _animalHabitat.value = if (animal?.habitat == "") {
            "本物種尚無棲息地描述"
        } else {
            animal?.habitat
        }

        // "最後更新時間" 該欄位的原始資料在第三方端，就已經格式錯誤了
        // 只有少數為人類可辨識的時間格式 string，故需做再做一層資料內容處理。
        _animalLastUpdateTime.value =
            if (animal?.lastUpdateTime == "" ||
                animal?.lastUpdateTime == "########" ||
                animal?.lastUpdateTime == "http://www.zoo.gov.tw/iTAP/03_Animals/BirdWorld/0_BirdWorld/GJ/GreenJunglefowl10.JPG"
            ) {
                "尚無最後更新時間"
            } else {
                animal?.lastUpdateTime
            }
    }
}