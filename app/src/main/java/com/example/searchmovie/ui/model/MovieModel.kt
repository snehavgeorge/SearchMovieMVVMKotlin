  package com.example.searchmovie.ui.model
import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("name") var name : String,
    @SerializedName("poster-image") var posterImage : String
)

  /*{

    @SerializedName("page") var page : Page

   data class Page (

        @SerializedName("title") var title : String,
        @SerializedName("total-content-items") var total_content_items : String,
        @SerializedName("page-num") var page_num : String,
        @SerializedName("page-size") var page_size : String,
        @SerializedName("content-items") var content_items : ContentItems

    )

    data class ContentItems (

    @SerializedName("content") var content : List<Content>

    )

    data class Content (

        @SerializedName("name") var name : String,
        @SerializedName("poster-image") var poster_image : String

    )
}*/

