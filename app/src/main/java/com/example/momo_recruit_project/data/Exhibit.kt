package com.example.momo_recruit_project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exhibit(
    @SerializedName("_id") val id: Int? = null,
    @SerializedName("_importdate") val importDate: ImportDate? = null,
    @SerializedName("e_no") val exhibitNumber: String? = null,
    @SerializedName("e_category") val category: String? = null,
    @SerializedName("e_name") val name: String,
    @SerializedName("e_pic_url") val picUrl: String? = null,
    @SerializedName("e_info") val info: String? = null,
    @SerializedName("e_memo") val memo: String? = null,
    @SerializedName("e_geo") val geo: String? = null,
    @SerializedName("e_url") val url: String? = null
) : Parcelable
