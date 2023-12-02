package com.example.momo_recruit_project.data.source

import android.util.Log
import com.example.momo_recruit_project.data.GeneralResult
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

    override suspend fun getAnimalExhibitList() : GeneralResult {
        return momoRemoteDataSource.getAnimalExhibitList()
    }

}