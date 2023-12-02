package com.example.momo_recruit_project.data.source

import androidx.lifecycle.LiveData
import com.example.momo_recruit_project.data.Animal
import com.example.momo_recruit_project.data.GeneralAnimalResult
import com.example.momo_recruit_project.data.GeneralExhibitResult
import javax.inject.Inject

class DefaultMomoRepository @Inject constructor(
    private val momoRemoteDataSource: MomoDataSource,
    private val momoLocalDataSource: MomoDataSource
) :
    MomoRepository {
    override fun test() {
        momoRemoteDataSource.test()
        momoLocalDataSource.test()
    }

    override suspend fun getAnimalExhibitList() : GeneralExhibitResult {
        return momoRemoteDataSource.getAnimalExhibitList()
    }

    override suspend fun getAllAnimalDetailList(): GeneralAnimalResult {
        return momoRemoteDataSource.getAllAnimalDetailList()
    }

    override suspend fun insertAnimalDetail(animal: Animal) {
        momoLocalDataSource.insertAnimalDetail(animal)
    }

    override suspend fun getAllAnimalDetailListFromDatabase()  : List<Animal>? {
        return momoLocalDataSource.getAllAnimalDetailListFromDatabase()
    }

    override suspend fun getAnimalDetailListByLocation(keyword: String): List<Animal> {
        return momoLocalDataSource.getAnimalDetailListByLocation(keyword)
    }

}