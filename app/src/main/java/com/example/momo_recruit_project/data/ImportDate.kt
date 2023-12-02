package com.example.momo_recruit_project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImportDate(
    val date: String? = null,
    @SerializedName("timezone_type") val timezoneType: Int? = null,
    val timezone: String? = null
) : Parcelable
