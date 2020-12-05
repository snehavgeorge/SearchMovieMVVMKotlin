package com.example.searchmovie.ui.view

import android.content.res.Configuration
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchmovie.R
import com.example.searchmovie.databinding.ActivitySearchBinding
import com.example.searchmovie.ui.adpter.MovieAdapter
import com.example.searchmovie.ui.model.MovieModel
import com.example.searchmovie.ui.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : AppCompatActivity() {
    private var movieAdapter : MovieAdapter ?= null
    //private val recyclerView: RecyclerView = findViewById(R.id.rv_movie)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        viewModel.getMovieList(this).observe(this, Observer {viewModels->
            movieAdapter = MovieAdapter(this,viewModels)
            rv_movie.layoutManager = GridLayoutManager(this,3)
            rv_movie!!.adapter = movieAdapter
        })

    }

    override fun onConfigurationChanged(newConfig: Configuration) {

        Log.e("onConfigurationChanged","onConfigurationChanged");
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.e("onConfigurationChanged","ORIENTATION_PORTRAIT");
            rv_movie.layoutManager = GridLayoutManager(this,3)
        }else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.e("onConfigurationChanged","ORIENTATION_LANDSCAPE");
            rv_movie.layoutManager = GridLayoutManager(this,7)
        }
        super.onConfigurationChanged(newConfig)
    }


}