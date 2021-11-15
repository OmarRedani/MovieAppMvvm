package com.ibm.movieappmvvm.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(
    val id: Int,
    val title: String,
    val poster_path: String?,
    val overview: String,
    val release_date:String
):Parcelable