package com.example.examensalinas.view.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.examensalinas.R
import com.example.examensalinas.databinding.PopularItemBinding
import com.example.examensalinas.model.data.ResultMovieEntity
import com.example.examensalinas.view.details.DetailFragment

class PopularMovieAdapter(
    private val listOfMoviePopular: List<ResultMovieEntity>,
    private var listenerDetail: MyClicks
) :
    RecyclerView.Adapter<PopularMovieAdapter.MyPopularViewHolder>() {

    inner class MyPopularViewHolder(val mBinding: PopularItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun setDetailListener(movieEntity: ResultMovieEntity) {
            mBinding.root.setOnClickListener {
                listenerDetail.myClickMovieDetails(movieEntity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPopularViewHolder {
        val context = parent.context
        val view: PopularItemBinding =
            PopularItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        return MyPopularViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyPopularViewHolder, position: Int) {
        with(holder) {
            holder.itemView.setOnClickListener { v ->
                val activity = v!!.context as AppCompatActivity
                val detail = DetailFragment()
                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.detailFragmentContainer, detail)
                    .commit()
            }
            with(listOfMoviePopular[position]) {
                setDetailListener(listOfMoviePopular[position])
                mBinding.tvPopularMovie.text = original_title
                val poster = imgPosterMovie()
                mBinding.imagePopularMovie.load(poster) {
                    crossfade(true)
                    crossfade(1_000)
                }
            }
        }
    }

    override fun getItemCount() = listOfMoviePopular.size
}