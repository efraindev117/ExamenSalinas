package com.example.examensalinas.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examensalinas.R
import com.example.examensalinas.databinding.FragmentHomeBinding
import com.example.examensalinas.model.data.ResultMovieEntity
import com.example.examensalinas.view.home.adapters.MyClicks
import com.example.examensalinas.view.home.adapters.NowMovieAdapter
import com.example.examensalinas.view.home.adapters.PopularMovieAdapter
import com.example.examensalinas.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), MyClicks {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //ViewModel
    private val mViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):View{
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        mViewModel.getDataCallbackPopularMovie().observe(viewLifecycleOwner) {
            binding.recyclerViewPopularMovie.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(
                    this@HomeFragment.context,
                    RecyclerView.HORIZONTAL, false
                )
                adapter = PopularMovieAdapter(it, this@HomeFragment)
            }
        }

        mViewModel.getDataCallbackNowMovie().observe(viewLifecycleOwner){
            binding.recyclerViewNowMovie.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@HomeFragment.context,RecyclerView.HORIZONTAL,false)
                adapter = NowMovieAdapter(it,this@HomeFragment)
            }
        }
    }

    override fun myClickMovieDetails(movie: ResultMovieEntity) {
        Toast.makeText(this.context, movie.title, Toast.LENGTH_SHORT).show()
        val bundle = Bundle()
        bundle.putParcelable("detailMovie",movie )
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle)

    }




}