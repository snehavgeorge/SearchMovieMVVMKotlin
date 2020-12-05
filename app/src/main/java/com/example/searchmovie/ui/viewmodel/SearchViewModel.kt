package com.example.searchmovie.ui.viewmodel

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.searchmovie.R
import com.example.searchmovie.ui.model.MovieModel
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


class SearchViewModel  : ViewModel {

    var name = ""
    var posterImage = ""

    constructor()
    constructor(movieModel: MovieModel) : this(){
        this.name = movieModel.name
        this.posterImage = movieModel.posterImage
    }

    var movieNames = MutableLiveData<ArrayList<SearchViewModel>>()
    var listMovieNames = ArrayList<SearchViewModel>()

    fun getMovieList(context: Context):MutableLiveData<ArrayList<SearchViewModel>>{
        val jsonFileString = getJsonDataFromAsset(context, "CONTENTLISTINGPAGE-PAGE1.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }
        val obj:JSONObject = JSONObject(jsonFileString!!)
        val movieArray   : JSONArray = obj.getJSONArray("content")

        for (i in 0 until movieArray.length()) {
            val movieDetail = movieArray.getJSONObject(i)
            val movieModel = MovieModel(movieDetail.getString("name"),movieDetail.getString("poster-image"))
            val searchViewModel : SearchViewModel = SearchViewModel(movieModel)
            listMovieNames!!.add(searchViewModel)
            movieNames.value = listMovieNames
        }
        return movieNames
    }
    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}

object DataBindingAdapters {

    @JvmStatic
    @BindingAdapter("image")
    fun setImageUrl(view: ImageView, resource: String) {
       // view.setImageURI   (Uri.parse(resource))
        Glide.with(view)
            .load(resource)
            .placeholder(R.drawable.poster1)
            .into(view)

    }


}