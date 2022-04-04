package com.example.salinasexamen.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examensalinas.model.data.ResultMovieEntity
import com.example.salinasexamen.model.interactor.MainInteraction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val interacts: MainInteraction) : ViewModel() {

    private val popularMovieResponse: MutableLiveData<List<ResultMovieEntity>> by lazy {
        MutableLiveData<List<ResultMovieEntity>>().also { loadDataPopular() }
    }

    private val nowMovieResponse: MutableLiveData<List<ResultMovieEntity>> by lazy {
        MutableLiveData<List<ResultMovieEntity>>().also { loadDataNow() }
    }

    fun getDataCallbackPopularMovie(): LiveData<List<ResultMovieEntity>> = popularMovieResponse

    fun getDataCallbackNowMovie(): LiveData<List<ResultMovieEntity>> = nowMovieResponse

    private fun loadDataPopular() = viewModelScope.launch {
        interacts.getDataPopularMovie { popularMovieResponse.value = it }
    }

    private fun loadDataNow() = viewModelScope.launch {
        interacts.getDataNowMovie { nowMovieResponse.value = it }
    }

}