package com.example.momo_recruit_project.data.source.remote

import android.util.Log
import com.example.momo_recruit_project.data.GeneralResult
import com.example.momo_recruit_project.data.source.MomoDataSource
import com.example.momo_recruit_project.network.MomoApi
import java.util.logging.Logger

object MomoRemoteDataSource : MomoDataSource {
    override fun test() {
        Log.i("test","hilt inject test")
    }

    override suspend fun getAnimalExhibitList() : GeneralResult {

        return try {

            val exhibitListResult = MomoApi.retrofitService.getAnimalExhibitList()

            exhibitListResult
        } catch (e: Exception) {
            GeneralResult()
        }
    }
}