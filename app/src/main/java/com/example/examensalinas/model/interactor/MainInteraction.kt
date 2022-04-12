package com.example.salinasexamen.model.interactor

import com.example.examensalinas.model.data.ResultMovieEntity
import com.example.examensalinas.repository.MovieRepository
import javax.inject.Inject


class MainInteraction @Inject constructor(private val movieRepository: MovieRepository) {
    // private lateinit var movieService: MoviesService

    suspend fun getDataPopularMovie(callback: (List<ResultMovieEntity>) -> Unit) {
        movieRepository.getAllServicePopularMovie().let {  response ->
            if (response.isSuccessful) {
                callback(response.body()!!.results)
            }
        }
        /*   val response = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            movieService = response.create(MoviesService::class.java)
            movieService.getPopularMovieData().enqueue(object :
                retrofit2.Callback<ResponseMostPopular> {
                override fun onResponse(
                    call: Call<ResponseMostPopular>,
                    response: Response<ResponseMostPopular>
                ){
                    val listOfPopularMovie = response.body()!!.results
                    callback(listOfPopularMovie)
                }

                override fun onFailure(call: Call<ResponseMostPopular>, t: Throwable) {
                    //Snackbar.make(this,"NO hay respuesta ",1000)
                }
            })*/
    }

    suspend fun getDataNowMovie(callback: (List<ResultMovieEntity>) -> Unit) {
        movieRepository.getAllServiceNowMovie().let {  response ->
            if (response.isSuccessful) {
                callback(response.body()!!.results)
            }
        }
        /*  val response = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            movieService = response.create(MoviesService::class.java)
            movieService.getNowMovieData().enqueue(object : retrofit2.Callback<ResponsePlayNow> {
                override fun onResponse(
                    call: Call<ResponsePlayNow>,
                    response: Response<ResponsePlayNow>
                ) {
                    val listOfNowMovie = response.body()!!.results
                    callback(listOfNowMovie)
                }

                override fun onFailure(call: Call<ResponsePlayNow>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })*/
    }
}