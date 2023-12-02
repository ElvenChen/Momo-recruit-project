package com.example.momo_recruit_project.data.source

import com.example.momo_recruit_project.data.GeneralAnimalResult
import com.example.momo_recruit_project.data.GeneralExhibitResult


interface MomoRepository {

    fun test()

    suspend fun getAnimalExhibitList() : GeneralExhibitResult

    suspend fun getAllAnimalDetailList() : GeneralAnimalResult
}