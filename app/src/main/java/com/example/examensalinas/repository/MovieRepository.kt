package com.example.examensalinas.repository

import com.example.examensalinas.network.MoviesService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val moviesService: MoviesService) {

    suspend fun getAllServiceNowMovie() = moviesService.getNowMovieData()
    suspend fun getAllServicePopularMovie() = moviesService.getPopularMovieData()


}