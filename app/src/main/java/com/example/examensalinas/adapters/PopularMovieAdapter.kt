package com.example.examensalinas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.examensalinas.databinding.PopularItemBinding
import com.example.examensalinas.model.data.ResultMovieEntity

class PopularMovieAdapter(private val listOfMoviePopular: List<ResultMovieEntity>) :
    RecyclerView.Adapter<PopularMovieAdapter.MyPopularViewHolder>() {

    class MyPopularViewHolder(val mBinding: PopularItemBinding) : RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPopularViewHolder {
        val context = parent.context
        val view: PopularItemBinding =
            PopularItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false)
        return MyPopularViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyPopularViewHolder, position: Int) {
        with(holder) {
            with(listOfMoviePopular[position]) {
                mBinding.tvPopularMovie.text = original_title
                val poster = imgPopularMovie()
                mBinding.imagePopularMovie.load(poster){
                    crossfade(true)
                    crossfade(1_000)
                }
            }
        }
    }

    override fun getItemCount() = listOfMoviePopular.size
}