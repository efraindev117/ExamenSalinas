package com.example.examensalinas.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.examensalinas.adapters.NowMovieAdapter
import com.example.examensalinas.adapters.PopularMovieAdapter
import com.example.examensalinas.databinding.ActivityMainBinding
import com.example.salinasexamen.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //ViewModel
    private val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
    }

    private fun setupViewModel() {
        //peliculas populares
        mViewModel.getDataCallbackPopularMovie().observe(this) {
            binding.recyclerViewPopularMovie.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity, HORIZONTAL, false)
                adapter = PopularMovieAdapter(it)
            }
        }

        //peliculas ahora
        mViewModel.getDataCallbackNowMovie().observe(this){
            binding.recyclerViewNowMovie.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity, HORIZONTAL,false)
                adapter = NowMovieAdapter(it)
            }
        }
    }
}


