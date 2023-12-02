package com.example.momo_recruit_project.data.source

import androidx.lifecycle.LiveData
import com.example.momo_recruit_project.data.Animal
import com.example.momo_recruit_project.data.GeneralAnimalResult
import com.example.momo_recruit_project.data.GeneralExhibitResult

interface MomoDataSource {

    fun test()
    // remote call

    suspend fun getAnimalExhibitList() : GeneralExhibitResult

    suspend fun getAllAnimalDetailList() : GeneralAnimalResult

    // local call

    suspend fun insertAnimalDetail(animal: Animal)

    suspend fun getAllAnimalDetailListFromDatabase() : List<Animal>?

    suspend fun getAnimalDetailListByLocation(keyword: String): List<Animal>
}