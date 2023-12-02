package com.example.momo_recruit_project.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "animal_table", primaryKeys = ["id"])
data class Animal(
    @SerializedName("_id") @ColumnInfo(name = "id") val id: Int? = null,
    @SerializedName("a_name_ch") @ColumnInfo(name = "chinese_name") val chineseName: String? = null,
    @SerializedName("a_alsoknown") @ColumnInfo(name = "also_known") val alsoknown: String? = null,
    @SerializedName("a_location") @ColumnInfo(name = "location") val location: String? = null,
    @SerializedName("a_name_en") @ColumnInfo(name = "english_name") val englishName: String? = null,
    @SerializedName("a_name_latin") @ColumnInfo(name = "latin_name") val latinName: String? = null,
    @SerializedName("a_phylum") @ColumnInfo(name = "phylum") val phylum: String? = null,
    @SerializedName("a_class") @ColumnInfo(name = "classes") val classes: String? = null,
    @SerializedName("a_order") @ColumnInfo(name = "order") val order: String? = null,
    @SerializedName("a_family") @ColumnInfo(name = "family") val family: String? = null,
    @SerializedName("a_distribution") @ColumnInfo(name = "distribution") val distribution: String? = null,
    @SerializedName("a_habitat") @ColumnInfo(name = "habitat") val habitat: String? = null,
    @SerializedName("a_feature") @ColumnInfo(name = "feature") val feature: String? = null,
    @SerializedName("a_behavior") @ColumnInfo(name = "behavior") val behavior: String? = null,
    @SerializedName("a_diet") @ColumnInfo(name = "diet") val diet: String? = null,
    @SerializedName("a_pic01_alt") @ColumnInfo(name = "pic_alt") val picAlt: String? = null,
    @SerializedName("a_pic01_url") @ColumnInfo(name = "pic_url") val picUrl: String? = null,
    @SerializedName("a_update") @ColumnInfo(name = "last_update_time") val lastUpdateTime: String? = null
) : Parcelable
