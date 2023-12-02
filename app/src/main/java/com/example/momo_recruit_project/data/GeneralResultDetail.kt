package com.example.momo_recruit_project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class GeneralResultDetail(
    @SerializedName("count") val count: Int? = null,
    @SerializedName("results") val results: List<Exhibit>? = null
) : Parcelable