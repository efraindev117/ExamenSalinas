package com.example.salinasexamen.model.data

import com.example.examensalinas.model.data.ResultMovieEntity

data class ResponseMovie(
    val page: Int,
    val results: List<ResultMovieEntity>
)