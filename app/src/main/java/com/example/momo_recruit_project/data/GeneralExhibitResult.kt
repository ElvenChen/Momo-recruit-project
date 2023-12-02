package com.example.momo_recruit_project.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GeneralExhibitResult(
    val result: GeneralExhibitResultDetail? = null
) : Parcelable
