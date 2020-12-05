package com.example.searchmovie.ui.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.searchmovie.R
import com.example.searchmovie.databinding.MovieBinding
import com.example.searchmovie.ui.model.MovieModel
import com.example.searchmovie.ui.viewmodel.SearchViewModel

class MovieAdapter(private val context:Context,private var moviesList: ArrayList<SearchViewModel>): RecyclerView.Adapter<MovieAdapter.MovieView>() {

    class MovieView(val movieBinding: MovieBinding):RecyclerView.ViewHolder(movieBinding.root){
        fun bind(searchViewModel: SearchViewModel){
            this.movieBinding.viewmodel = searchViewModel
            movieBinding.executePendingBindings(  )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieBinding : MovieBinding = DataBindingUtil.inflate(layoutInflater,R.layout.item_data,parent,false)
        return MovieView(movieBinding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieView, position: Int) {
        val searchViewModel = moviesList[position]
        holder.bind(searchViewModel)
    }
}