package com.example.salinasexamen.network

import com.example.salinasexamen.model.data.ResponseMovie
import com.example.salinasexamen.utils.Constants.API_KEY
import com.example.salinasexamen.utils.Constants.END_POINT_MOVIE_NOW
import com.example.salinasexamen.utils.Constants.END_POINT_MOVIE_POPULAR
import com.example.salinasexamen.utils.Constants.QUERY_OPTIONAL
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    // peliculas populares
    @GET(END_POINT_MOVIE_POPULAR + API_KEY + QUERY_OPTIONAL)
   suspend fun getPopularMovieData(): Response<ResponseMovie>

    // peliculas reproduciendo ahora
    @GET(END_POINT_MOVIE_NOW + API_KEY + QUERY_OPTIONAL)
    suspend fun getNowMovieData(): Response<ResponseMovie>
}