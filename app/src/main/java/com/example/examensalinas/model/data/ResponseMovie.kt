package com.example.examensalinas.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class ResponseMovie(
    val page: Int,
    val results: List<ResultMovieEntity>
)