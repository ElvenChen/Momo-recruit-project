package com.example.momo_recruit_project.data.source

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

}