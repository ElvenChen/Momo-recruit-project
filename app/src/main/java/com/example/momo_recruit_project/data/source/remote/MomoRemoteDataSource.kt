package com.example.momo_recruit_project.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.momo_recruit_project.data.Animal
import com.example.momo_recruit_project.data.GeneralAnimalResult
import com.example.momo_recruit_project.data.GeneralExhibitResult
import com.example.momo_recruit_project.data.source.MomoDataSource
import com.example.momo_recruit_project.network.MomoApi
import java.util.logging.Logger

object MomoRemoteDataSource : MomoDataSource {
    override fun test() {
        Log.i("test","hilt inject test")
    }

    override suspend fun getAnimalExhibitList() : GeneralExhibitResult {

        return try {

            val exhibitListResult = MomoApi.retrofitService.getAnimalExhibitList()

            exhibitListResult
        } catch (e: Exception) {
            GeneralExhibitResult()
        }
    }

    override suspend fun getAllAnimalDetailList(): GeneralAnimalResult {
        return try {

            val animalDetailListResult = MomoApi.retrofitService.getAllAnimalDetailList()

            animalDetailListResult
        } catch (e: Exception) {
            GeneralAnimalResult()
        }
    }

    override suspend fun insertAnimalDetail(animal: Animal) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllAnimalDetailListFromDatabase() : List<Animal>? {
        TODO("Not yet implemented")
    }

    override suspend fun getAnimalDetailListByLocation(keyword: String): List<Animal> {
        TODO("Not yet implemented")
    }
}