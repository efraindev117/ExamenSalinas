package com.example.examensalinas.view.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.examensalinas.databinding.FragmentDetailBinding
import com.example.examensalinas.model.data.ResultMovieEntity


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieDetailFragment: ResultMovieEntity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):View{
        _binding = FragmentDetailBinding.inflate(inflater,container,false)

        requireArguments().let {
            movieDetailFragment = it.getParcelable("detailMovie")!!
            //comprobación de que si estan pasando los datos
            Log.d("detalles de las peliculas","$movieDetailFragment")
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgMovie.load(movieDetailFragment.imgBackdropMovie()) {
            crossfade(true)
            crossfade(1_000)
        }
        binding.txtTitleMovie.text = movieDetailFragment.title
        binding.txtRate.text = movieDetailFragment.popularity.toString()
        binding.txtOverview.text = movieDetailFragment.overview
        binding.txtEstreno.text = "Release date: ${movieDetailFragment.release_date}"
        binding.txtLanguage.text = "Language: ${movieDetailFragment.original_language}."
        binding.txtvotes.text = "Vote average: ${movieDetailFragment.vote_average} (${movieDetailFragment.vote_count} votes.)"
    }
}