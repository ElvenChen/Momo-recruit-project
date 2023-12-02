package com.example.momo_recruit_project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GeneralAnimalResultDetail(
    @SerializedName("count") val count: Int? = null,
    @SerializedName("results") val results: List<Animal>? = null
) : Parcelable
