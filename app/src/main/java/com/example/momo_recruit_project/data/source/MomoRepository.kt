package com.example.momo_recruit_project.data.source

import com.example.momo_recruit_project.data.GeneralResult


interface MomoRepository {

    fun test()

    suspend fun getAnimalExhibitList() : GeneralResult
}