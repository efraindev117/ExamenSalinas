package com.example.salinasexamen.repository

import com.example.salinasexamen.network.MoviesService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val moviesService: MoviesService) {

    suspend fun getAllServiceNowMovie() = moviesService.getNowMovieData()
    suspend fun getAllServicePopularMovie() = moviesService.getPopularMovieData()


}