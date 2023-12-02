package com.example.momo_recruit_project.data.source.local

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.momo_recruit_project.data.Animal
import com.example.momo_recruit_project.data.GeneralAnimalResult
import com.example.momo_recruit_project.data.GeneralExhibitResult
import com.example.momo_recruit_project.data.source.MomoDataSource
import javax.inject.Inject


class MomoLocalDataSource @Inject constructor (private val dao: MomoDatabaseDao) : MomoDataSource {
    override fun test() {
        Log.i("test","$dao hilt inject database test")
    }

    override suspend fun getAnimalExhibitList() : GeneralExhibitResult {
        TODO("Not yet implemented")
    }

    override suspend fun getAllAnimalDetailList(): GeneralAnimalResult {
        TODO("Not yet implemented")
    }

    override suspend fun insertAnimalDetail(animal: Animal) {
        dao.insert(animal)
    }

    override suspend fun getAllAnimalDetailListFromDatabase() : List<Animal>? {
        return dao.getAllAnimalDetailList()
    }

    override suspend fun getAnimalDetailListByLocation(keyword: String): List<Animal> {
        return dao.getAnimalDetailListByLocation(keyword)
    }
}