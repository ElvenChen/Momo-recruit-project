package com.example.momo_recruit_project.data.source.remote

import android.util.Log
import com.example.momo_recruit_project.data.source.MomoDataSource

object MomoRemoteDataSource : MomoDataSource {
    override fun test() {
        Log.i("test","hilt inject test")
    }
}