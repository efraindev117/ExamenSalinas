package com.example.examensalinas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.examensalinas.databinding.NowItemBinding
import com.example.examensalinas.model.data.ResultMovieEntity

class NowMovieAdapter(private val listOfMovieNow: List<ResultMovieEntity>) :
    RecyclerView.Adapter<NowMovieAdapter.MyNowViewHolder>() {

    inner class MyNowViewHolder(val mBinding: NowItemBinding) :
        RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNowViewHolder {
        val context = parent.context
        val view: NowItemBinding =
            NowItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        return MyNowViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyNowViewHolder, position: Int) {
        with(holder) {
            with(listOfMovieNow[position]) {
                mBinding.tvNowMovie.text = original_title
                val poster = imgPopularMovie()
                mBinding.imageNowMovie.load(poster) {
                    crossfade(true)
                    crossfade(1_000)
                }
            }
        }
    }

    override fun getItemCount() = listOfMovieNow.size

}