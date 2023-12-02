package com.example.momo_recruit_project.data.source.local

import android.util.Log
import com.example.momo_recruit_project.data.source.MomoDataSource
import javax.inject.Inject


class MomoLocalDataSource @Inject constructor (private val dao: MomoDatabaseDao) : MomoDataSource {
    override fun test() {
        Log.i("test","$dao hilt inject database test")
    }
}