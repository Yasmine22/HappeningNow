package com.example.happeningnow.models

import com.google.gson.annotations.SerializedName


data class NewsResponse (

	@SerializedName("status") val status : String,
	@SerializedName("copyright") val copyright : String,
	@SerializedName("section") val section : String,
	@SerializedName("last_updated") val last_updated : String,
	@SerializedName("num_results") val num_results : Int,
	@SerializedName("results") val results : List<NewsModel>
)