package com.example.examensalinas.model.data

import android.os.Parcelable
import com.example.examensalinas.utils.Constants.BASE_POSTER_IMG
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultMovieEntity(
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) : Parcelable {
    fun imgPosterMovie(): String = BASE_POSTER_IMG + poster_path
    fun imgBackdropMovie(): String = BASE_POSTER_IMG + backdrop_path
}



